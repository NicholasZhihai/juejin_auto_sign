package com.example.mytestpro.service;

import com.alibaba.fastjson.TypeReference;
import com.example.mytestpro.constans.Constans;

import com.example.mytestpro.constans.enums.Cookies;
import com.example.mytestpro.service.response.CalendarResponse;
import com.example.mytestpro.service.response.DrawResponse;
import com.example.mytestpro.util.RedisUtil;
import com.example.mytestpro.util.TimeFormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Map;

/**
 * @author lizhihai
 * @date 2021/09/11
 */
@Slf4j
@Service
public class MainSchedule {
    private final static Logger logger = LoggerFactory.getLogger(MainSchedule.class);
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    private SendHttps sendHttps;

//    //@Scheduled(cron = "0/15 * * * * ?")
//    @Scheduled(cron = "0 8 0 * * ?")
    public void calendar() throws Exception {
        CalendarResponse calendarText = getCalendarText();
        String calendarStr = calendarText.getData().toString();
        sendHttps.sendToDingDing(calendarStr);
        redisUtil.zAdd(Constans.REDIS_KEY_CALENDAR,calendarStr,TimeFormatUtil.DateToDouble(new Date(),TimeFormatUtil.YYYYMMDD));
    }
    @Scheduled(cron = "0 0 8 * * ?")
    public void execute() throws Exception {
        logger.info("定时任务开始");
        for(Cookies cookie:Cookies.values()){
            boolean hasSign=checkIn(cookie);
            if(hasSign) {continue;}
            //第一次免费抽奖
            draw(cookie);
            //还能抽就继续干
            while(cookie.isAllIn()&&getCurPoint(cookie)>=200){
                draw(cookie);
                Thread.sleep(3000);//休眠三秒，钉钉机器人每分钟最多发20次消息，不然抽到好东西也收不到钉钉
            }
        }
        calendar();
        logger.info("执行结束");
    }

    /**
     * 签到
     *
     * @throws Exception
     */
    public boolean checkIn(Cookies cookie) throws Exception {
        String response = commonRequest(Constans.CHECK_IN, Constans.POST,cookie);
        logger.info("{}{}",cookie.getName(),response);
        boolean hasSign=!response.contains("err_no\":0");
        if(hasSign){
            sendHttps.sendToDingDing(cookie.getName()+response);
        }
        return hasSign;
    }

    /**
     * 抽奖
     *
     * @throws Exception
     */
    public void draw(Cookies cookie) throws Exception {
        String response = commonRequest(Constans.DRAW, Constans.POST,cookie);
        DrawResponse data= JSON.parseObject(response,new TypeReference<DrawResponse>(){});
        String prizeName=data.getData().getLotteryName();
        if(!"66矿石".equals(prizeName)&&!prizeName.contains("Bug")){
            log.error("抽到好东西了！！！！！！");
            //发送到钉钉
        }
        log.info("{}抽到{}",cookie.getName(),prizeName);
        sendHttps.sendToDingDing(cookie.getName()+"抽到"+prizeName);
    }

    /**
     * 查询剩余矿石
     * @return
     * @throws Exception
     */
    public int getCurPoint(Cookies cookie) throws Exception {
        String response = commonRequest(Constans.GET_CUR_POINT, Constans.GET,cookie);
        logger.info(response);
        Map<String, Object> res = JSON.parseObject(response);
        int curPoint = (int) res.get("data");
        logger.info("{}还剩{}矿石", cookie.getName(),curPoint);
        return curPoint;
    }
    /**
     * 查询每日程序员日历文案
     */
    public CalendarResponse getCalendarText() throws Exception {
        String response=commonRequest(Constans.GET_CODER_CLENDAR,Constans.GET,Cookies.HAI1);
        CalendarResponse data= JSON.parseObject(response,new TypeReference<CalendarResponse>(){});
        log.info(data.toString());
        return data;
    }

    /**
     * 通用https请求方法 掘金是https协议有证书请求
     *
     * @param url
     * @param method
     * @return
     * @throws Exception
     */
    public String commonRequest(String url, String method, Cookies cookie) throws Exception {
        URL serverUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
        conn.setRequestMethod(method);
        conn.setRequestProperty("Content-type", "application/json");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36");
        conn.setRequestProperty("Cookie", cookie.getValue());
        //必须设置false，否则会自动redirect到重定向后的地址
        conn.setInstanceFollowRedirects(false);
        conn.connect();
        String result = getReturn(conn);
        return result;
    }

    /*请求url获取返回的内容*/
    public static String getReturn(HttpURLConnection connection) throws IOException {
        StringBuffer buffer = new StringBuffer();
        //将返回的输入流转换成字符串
        try (InputStream inputStream = connection.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            String result = buffer.toString();
            return result;
        }
    }

}
