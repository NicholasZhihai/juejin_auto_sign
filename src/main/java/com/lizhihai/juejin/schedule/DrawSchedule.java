package com.lizhihai.juejin.schedule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.lizhihai.juejin.constans.JuejinApi;
import com.lizhihai.juejin.domain.Cookies;
import com.lizhihai.juejin.domain.response.*;
import com.lizhihai.juejin.util.Dingding;
import com.lizhihai.juejin.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DrawSchedule {
    @Resource
    private Dingding dingding;
    @Resource
    private MongoTemplate mongoTemplate;
    private final static Logger logger = LoggerFactory.getLogger(DrawSchedule.class);
    @Scheduled(cron = "0 0 8 * * ?")
//    @Scheduled(cron = "0/2 * * * * ?")
    public void draw() throws Exception {
        List<Cookies> allByIsDeleteNot = mongoTemplate.findAll(Cookies.class);
        for (Cookies item:allByIsDeleteNot) {
            boolean hasSign = checkIn(item);
            if (hasSign) {
                continue;
            }
            //第一次免费抽奖
            draw(item);
            int curPoint = getCurPoint(item);
            dingding.send(item.getUserName()+"剩余矿石"+curPoint);
            if (item.isDrawAll()) {
                while (getCurPoint(item) >= 200) {
                    draw(item);
                    Thread.sleep(3000);//休眠三秒，钉钉机器人每分钟最多发20次消息
                }
            }
            String lucky = getLucky(item);
            dipLucky(item,lucky);
            BugList bugs = getBugs(item);
            for (BugList.DataDTO bug:bugs.getData()) {
                bugFix(item,bug.getBugTime(), bug.getBugType());
            }
        }
    }


    /**
     * 签到
     */
    public boolean checkIn(Cookies cookie) throws Exception {
        String response = HttpUtil.commonRequest(JuejinApi.CHECK_IN, JuejinApi.POST, cookie.getCookie());
        logger.info("{}{}", cookie.getUserName(), response);
        boolean hasSign = !response.contains("err_no\":0");
        if (hasSign) {
            dingding.send(cookie.getUserName() + response);
        }
        return hasSign;
    }

    /**
     * 抽奖
     */
    public void draw(Cookies cookie) throws Exception {
        String response = HttpUtil.commonRequest(JuejinApi.DRAW, JuejinApi.POST, cookie.getCookie());
        DrawResponse data = JSON.parseObject(response, new TypeReference<DrawResponse>() {
        });
        String prizeName = data.getData().getLotteryName();
        if (!prizeName.contains("矿石") && !prizeName.contains("Bug")) {
            logger.error("抽到好东西了！！！！！！");
            //发送到钉钉
        }
        logger.info("{}抽到{}", cookie.getUserName(), prizeName);
        dingding.send(cookie.getUserName() + "抽到" + prizeName);
    }

    /**
     * 查询沾喜气列表
     */
    public String getLucky(Cookies cookies) throws Exception {
        Map<String, Object> map =new HashMap<>();
        map.put("page_no",1);
        map.put("page_size",5);
        String response = HttpUtil.commonRequest(JuejinApi.GET_LUCKY, JuejinApi.POST,cookies.getCookie(), map);
        LuckyResponse data = JSON.parseObject(response, new TypeReference<LuckyResponse>() {
        });
        return data.getData().getLotteries().get(0).getHistoryId();
    }
    /**
     * 沾喜气
     */
    public void dipLucky(Cookies cookie,String id) throws Exception {
        Map<String, Object> param =new HashMap<>();
        param.put("lottery_history_id",id);
        String response = HttpUtil.commonRequest(JuejinApi.DIP_LUCKY, JuejinApi.POST,cookie.getCookie(), param);
        DipLucky data = JSON.parseObject(response, new TypeReference<DipLucky>() {
        });
        if (data.getErrNo()!=0){
            logger.error("沾喜气失败{}{}",cookie.getUserName(),data.getErrMsg());
            dingding.send(cookie.getUserName()+"沾喜气失败"+data.getErrMsg());
        }
        else{
            dingding.send(cookie.getUserName()+"沾喜气成功");
        }
    }
    /**
     * 查询bug列表
     */
    public BugList getBugs(Cookies cookies) throws Exception {
        Map<String, Object> map =new HashMap<>();
        map.put("page_no",1);
        map.put("page_size",20);
        String response = HttpUtil.commonRequest(JuejinApi.BUGS, JuejinApi.POST,cookies.getCookie(), map);
        return JSON.parseObject(response, new TypeReference<BugList>() {
        });
    }
    /**
     * bugFix
     */
    public void bugFix(Cookies cookie,Integer bugTime,Integer bugType) throws Exception {
        Map<String, Object> param =new HashMap<>();
        param.put("bug_time",bugTime);
        param.put("bug_type",bugType);
        String response = HttpUtil.commonRequest(JuejinApi.COLLECT_BUG, JuejinApi.POST,cookie.getCookie(), param);
        if (!response.contains("err_no\":0")){
            logger.error("bugFix失败{}{}",cookie.getUserName(),response);
            dingding.send(cookie.getUserName()+"bugFix失败"+response);
        }else {
            dingding.send(cookie.getUserName()+"bugFix成功"+response);
        }
    }


    /**
     * 查询剩余矿石
     */
    public int getCurPoint(Cookies cookie) throws Exception {
        String response = HttpUtil.commonRequest(JuejinApi.GET_CUR_POINT, JuejinApi.GET, cookie.getCookie());
        logger.info(response);
        Map<String, Object> res = JSON.parseObject(response);
        int curPoint = (int) res.get("data");
        logger.info("{}还剩{}矿石",cookie.getUserName(), curPoint);
        return curPoint;
    }

    /**
     * 查询每日程序员日历文案
     */
    public CalendarResponse getCalendarText(Cookies cookie) throws Exception {
        String response = HttpUtil.commonRequest(JuejinApi.GET_CODER_CLENDAR, JuejinApi.GET, cookie.getCookie());
        CalendarResponse data = JSON.parseObject(response, new TypeReference<CalendarResponse>() {
        });
        logger.info(data.toString());
        return data;
    }
}
