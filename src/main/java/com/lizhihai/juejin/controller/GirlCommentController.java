package com.lizhihai.juejin.controller;

import com.lizhihai.juejin.constans.JuejinApi;
import com.lizhihai.juejin.domain.Cookies;
import com.lizhihai.juejin.util.HttpUtil;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GirlCommentController {
    @Resource
    private MongoTemplate mongoTemplate;
    @RequestMapping("/commentGirl")
    public Map<String, Object> girlComment(@RequestParam("comment")String comment,@RequestParam("aim")String aim) throws Exception {
        Map<String, Object> param =new HashMap<>();
        param.put("item_id",aim);
        param.put("client_type",2608);
        param.put("comment_content",comment);
        param.put("item_type",4);
        HttpUtil.commonRequest(JuejinApi.COMMENT, JuejinApi.POST,JuejinApi.lizhihai.getCookie(), param);
        Map<String, Object> res =new HashMap<>();
        res.put("res","评论成功");
        return res;
    }
}
