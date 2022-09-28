package com.lizhihai.juejin.schedule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.lizhihai.juejin.constans.JuejinApi;
import com.lizhihai.juejin.domain.response.Girl;
import com.lizhihai.juejin.domain.response.Xiangqin;
import com.lizhihai.juejin.util.Dingding;
import com.lizhihai.juejin.util.HttpUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ReptileSchedule {
    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private Dingding dingding;


    @Scheduled(cron = "0 0 17 * * ?")
//    @Scheduled(cron = "0/5 * * * * ?")
    public void climb() throws Exception {

        String response = HttpUtil.commonRequest(JuejinApi.XQJ, JuejinApi.POST, JuejinApi.lizhihai.getCookie(), (Map<String, Object>) JSON.parseObject(JuejinApi.xiangQinReq, Map.class));
        Xiangqin data = JSON.parseObject(response, new TypeReference<Xiangqin>() {
        });

        for (Xiangqin.DataDTO e : data.getData()) {
            String content = e.getMsgInfo().getContent();
            boolean isBoy = content.contains("性别:男") || content.contains("性别：男") || content.contains("性别男") || content.contains("女朋友") || content.contains("小伙");
            if (isBoy) {
                continue;
            }
            boolean isGirl = content.contains("性别:女") || content.contains("性别：女") || content.contains("性别女") || content.contains("男朋友") || content.contains("男友") || content.contains("男票") || content.contains("姐妹");
            Girl girl = matchGirl(new Girl(), content);
            girl.setContent(content);
            girl.setJuejinAccount(e.getMsgInfo().getUserId());
            if (isGirl || girl.isValid()) {
                Query query = new Query();
                Criteria c = new Criteria();
                c.orOperator(Criteria.where("juejinAccount").is(girl.getJuejinAccount()), Criteria.where("content").is(girl.getContent()));
                query.addCriteria(c);
                List<Girl> sameAccount = mongoTemplate.find(query, Girl.class);
                if (CollectionUtils.isEmpty(sameAccount)) {
                    mongoTemplate.save(girl);
                    Thread.sleep(3000);
                    dingding.send("快马来报！", content, "https://juejin.cn/user/" + e.getMsgInfo().getUserId() + "/pins", e.getMsgId(), "18390921146");
                }
            }
        }
    }

    public Girl matchGirl(Girl girl, String content) {
        String regexNum = "[0-9]+";
        Pattern numPattern = Pattern.compile(regexNum);//匹配任意位数字
        Matcher matcher = numPattern.matcher(content);
        while (matcher.find()) {
            String num = matcher.group();
            if (num.length() == 4) {
                if (num.startsWith("199") || num.startsWith("200")) {//199 200开头的认定为出生年份
                    girl.setBirth(num);
                }
            } else if (num.length() == 3) {
                if (Integer.parseInt(num) > 169 || Integer.parseInt(num) < 149) {
                    return girl;//超过170 一般认为是男生 直接结束
                } else {
                    girl.setValid(true);//149-169之间认定为女生
                    girl.setHeight(num);
                }
            } else if (num.length() == 2) {
                if (Integer.parseInt(num) > 90) {//90以上认定为出生年份
                    girl.setBirth(String.valueOf(1900 + Integer.parseInt(num)));
                } else if (Integer.parseInt(num) > 18 && Integer.parseInt(num) < 30) {//18-30认定为年龄
                    girl.setBirth(String.valueOf(LocalDate.now().getYear() - Integer.parseInt(num)));
                } else if (Integer.parseInt(num) > 40 && Integer.parseInt(num) < 59) {//40-60认定为体重
                    girl.setValid(true);
                    girl.setWeight(num);
                }
            }
        }
        int cityIndex = content.indexOf("坐标");
        if (cityIndex != -1) {
            girl.setCity(content.substring(cityIndex + 2, cityIndex + 4));
        }
        return girl;
    }

}
