package com.lizhihai.juejin.controller;

import com.lizhihai.juejin.constans.JuejinApi;
import com.lizhihai.juejin.domain.Image;
import com.lizhihai.juejin.schedule.DrawSchedule;
import com.lizhihai.juejin.util.HttpClientUtil;
import com.lizhihai.juejin.util.ImageOrcUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GirlCommentController {
    @Resource
    private DrawSchedule drawSchedule;

    @RequestMapping("/commentGirl")
    public Map<String, Object> girlComment(@RequestParam("comment") String comment, @RequestParam("aim") String aim) throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("item_id", aim);
        param.put("client_type", 2608);
        param.put("comment_content", comment);
        param.put("item_type", 4);
        HttpClientUtil.commonRequest(JuejinApi.COMMENT, JuejinApi.POST, JuejinApi.lizhihai.getCookie(), param);
        Map<String, Object> res = new HashMap<>();
        res.put("res", "评论成功");
        return res;
    }

    @RequestMapping("/refresh")
    public String refresh() throws Exception {
        drawSchedule.draw();
        return "success";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/ocr")
    public String ocr(@RequestBody Image image) throws Exception {
        return ImageOrcUtil.getOcr(image.getImage());
    }
}
