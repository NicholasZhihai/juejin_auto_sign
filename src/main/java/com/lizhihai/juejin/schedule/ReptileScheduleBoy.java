package com.lizhihai.juejin.schedule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.lizhihai.juejin.constans.JuejinApi;
import com.lizhihai.juejin.domain.response.Boy;
import com.lizhihai.juejin.domain.response.Xiangqin;
import com.lizhihai.juejin.util.Base64Method;
import com.lizhihai.juejin.util.HttpClientUtil;
import com.lizhihai.juejin.util.QYWXUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ReptileScheduleBoy {
    public static final String KEY_LAST_CURSOR_INDEX = "KEY_LAST_CURSOR_INDEX";
    @Resource
    private MongoTemplate mongoTemplate;
    //    @Resource
//    private Dingding dingding;
    @Resource
    private QYWXUtil qywxUtil;
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    //    @Scheduled(cron = "0 0 17 * * ?")
//    @Scheduled(cron = "0 0 * * * ?")
    public void climb() throws Exception {
        for (int i = 0; i < 10000; i++) {
            String lastIndexString = redisTemplate.opsForValue().get(KEY_LAST_CURSOR_INDEX);
            int lastIndex = StringUtils.isEmpty(lastIndexString) ? 0 : Integer.parseInt(lastIndexString);
            Map<String, Object> cursor = new HashMap<>();
            cursor.put("v", "7263115061182808101");
            cursor.put("i", lastIndex);
            String s = Base64Method.EncryptBase64(com.alibaba.fastjson2.JSON.toJSONString(cursor));
            climbByIndex(s);
            redisTemplate.opsForValue().set(KEY_LAST_CURSOR_INDEX, String.valueOf(lastIndex + 100));
        }
//        Map<String, Object> cursor = new HashMap<>();
//        cursor.put("v", "7263115061182808101");
//        cursor.put("i", 0);
//        String s = Base64Method.EncryptBase64(com.alibaba.fastjson2.JSON.toJSONString(cursor));
//        climbByIndex(s);
    }

    public void climbByIndex(String cursor) throws Exception {
        Map<String, Object> map = (Map<String, Object>) JSON.parseObject(JuejinApi.xiangQinReq, Map.class);
        map.put("cursor", cursor);
        String response = HttpClientUtil.commonRequest(JuejinApi.XQJ, JuejinApi.POST, JuejinApi.lizhihai.getCookie(), map);
        Xiangqin data = JSON.parseObject(response, new TypeReference<Xiangqin>() {
        });

        for (Xiangqin.DataDTO e : data.getData()) {
            String content = e.getMsgInfo().getContent();
            boolean isBoy = StringUtils.containsAny(content, "性别:男", "性别：男", "性别男", "女朋友", "女友", "小姐姐", "姐妹", "兄弟");
            Boy boy = matchBoy(new Boy(), content);
            boy.setContent(content);
            boy.setJuejinAccount(e.getMsgInfo().getUserId());
            boy.setPicList(e.getMsgInfo().getPicList());
            if (isBoy || boy.isValid()) {
                Query query = new Query();
                Criteria c = new Criteria();
                c.orOperator(Criteria.where("juejinAccount").is(boy.getJuejinAccount()), Criteria.where("content").is(boy.getContent()));
                query.addCriteria(c);
                List<Boy> sameAccount = mongoTemplate.find(query, Boy.class);
                if (CollectionUtils.isEmpty(sameAccount)) {
                    mongoTemplate.save(boy);
                    Thread.sleep(3000);
                    StringBuilder sb = new StringBuilder();
                    sb.append("高质量！\n");
                    if (StringUtils.isNoneEmpty(boy.getBirth())) {
                        sb.append("年龄：" + boy.getBirth() + "\n");
                    }
                    if (StringUtils.isNoneEmpty(boy.getHeight())) {
                        sb.append("身高：" + boy.getHeight() + "\n");
                    }
                    if (StringUtils.isNoneEmpty(boy.getWeight())) {
                        sb.append("体重：" + boy.getWeight() + "\n");
                    }
                    if (StringUtils.isNoneEmpty(boy.getCity())) {
                        sb.append(boy.getWeight() + "\n");
                    }
                    if (StringUtils.isNoneEmpty(boy.getHome())) {
                        sb.append(boy.getHome() + "\n");
                    }
                    String linkUrl = "https://juejin.cn/pin/" + e.getMsgId() + "#comment";
                    boy.setLinkUrl(linkUrl);

                    if (!CollectionUtils.isEmpty(e.getMsgInfo().getPicList())) {
                        System.out.println(e.getMsgInfo().getPicList());
//                        qywxUtil.sendPicture(content, linkUrl, e.getMsgInfo().getPicList());
                    } else {
                        //qywxUtil.sendMarkDown(sb.toString() + " 可以无脑 冲冲冲", Arrays.asList("18390921146"), linkUrl);
                    }
                    //dingding.send("快马来报！", content, "https://juejin.cn/user/" + e.getMsgInfo().getUserId() + "/pins", e.getMsgId(), "18390921146");
                }
            }
        }
    }

    public Boy matchBoy(Boy boy, String content) {
        String regexNum = "[0-9]+";
        Pattern numPattern = Pattern.compile(regexNum);//匹配任意位数字
        Matcher matcher = numPattern.matcher(content);
        while (matcher.find()) {
            String num = matcher.group();
            if (num.length() == 4) {
                if (num.startsWith("199") || num.startsWith("200")) {//199 200开头的认定为出生年份
                    boy.setBirth(num);
                }
            } else if (num.length() == 3) {
                if ( Integer.parseInt(num) < 168) {
                    return boy;
                } else {
                    boy.setValid(true);//149-166之间认定为女生
                    boy.setHeight(num);
                }
            } else if (num.length() == 2) {
                if (Integer.parseInt(num) > 90) {//90以上认定为出生年份
                    boy.setBirth(String.valueOf(1900 + Integer.parseInt(num)));
                } else if (Integer.parseInt(num) > 18 && Integer.parseInt(num) < 30) {//18-30认定为年龄
                    boy.setBirth(String.valueOf(LocalDate.now().getYear() - Integer.parseInt(num)));
                } else if (Integer.parseInt(num) > 58) {
                    boy.setValid(true);
                    boy.setWeight(num);
                }
            }
        }
        int cityIndex = content.indexOf("坐标");
        try {
            if (cityIndex != -1) {
                boy.setCity(content.substring(cityIndex, cityIndex + 5));
            }
            int homeIndex = content.indexOf("老家");
            if (homeIndex != -1) {
                boy.setHome(content.substring(homeIndex, homeIndex + 5));
            }
        } catch (Exception e) {
        }
        return boy;
    }

}
