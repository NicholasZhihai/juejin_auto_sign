package com.lizhihai.juejin;

import com.lizhihai.juejin.domain.BaiduResou;
import com.lizhihai.juejin.domain.Guba;
import com.lizhihai.juejin.schedule.BaiduSchedule;
import com.lizhihai.juejin.schedule.GubaSchedule;
import com.lizhihai.juejin.util.Dingding;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootTest
class JuejinApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    GubaSchedule gubaSchedule;
    @Autowired
    BaiduSchedule baiduSchedule;

    @Test
    public void baidu() throws Exception {
        baiduSchedule.refresh();

    }

    @Test
    public void guba() throws Exception {
//        getPage("601519", 1);
        gubaSchedule.getPage("002415", 2);
        gubaSchedule.getPage("002415", 10);
        gubaSchedule.getPage("002415", 20);
        gubaSchedule.getPage("002415", 200);
        gubaSchedule.getPage("002415", 600);
    }

    @Test
    public void thread() throws Exception {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(LocalDateTime.now());
            }
        }, 1000, 5000);
    }

}
