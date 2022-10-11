package com.lizhihai.juejin.controller;

import com.lizhihai.juejin.constans.JuejinApi;
import com.lizhihai.juejin.schedule.DrawSchedule;
import com.lizhihai.juejin.util.HttpUtil;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GirlCommentController {
    @Resource
    private DrawSchedule drawSchedule;
    private final ThreadPoolTaskExecutor executor =new ThreadPoolTaskExecutor();

    @RequestMapping("/commentGirl")
    public Map<String, Object> girlComment(@RequestParam("comment") String comment, @RequestParam("aim") String aim) throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("item_id", aim);
        param.put("client_type", 2608);
        param.put("comment_content", comment);
        param.put("item_type", 4);
        HttpUtil.commonRequest(JuejinApi.COMMENT, JuejinApi.POST, JuejinApi.lizhihai.getCookie(), param);
        Map<String, Object> res = new HashMap<>();
        res.put("res", "评论成功");
        return res;
    }

    @RequestMapping("/refresh")
    public String refresh() {
        executor.execute(() -> {
            try {
                drawSchedule.draw();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return "success";
    }
}
