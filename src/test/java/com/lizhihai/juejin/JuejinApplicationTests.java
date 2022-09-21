package com.lizhihai.juejin;

import com.lizhihai.juejin.domain.Guba;
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

@SpringBootTest
class JuejinApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    GubaSchedule gubaSchedule;

    @Test
    public void guba() throws Exception {
//        getPage("601519", 1);
        gubaSchedule.getPage("002415", 2);
        gubaSchedule.getPage("002415", 10);
        gubaSchedule.getPage("002415", 20);
        gubaSchedule.getPage("002415", 200);
        gubaSchedule.getPage("002415", 600);
    }

}
