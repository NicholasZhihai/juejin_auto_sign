package com.lizhihai.juejin;

import com.lizhihai.juejin.schedule.BaiduSchedule;
import com.lizhihai.juejin.schedule.GubaSchedule;
import com.lizhihai.juejin.schedule.ReptileSchedule;
import com.lizhihai.juejin.schedule.ReptileScheduleBoy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootTest
class JuejinApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    Son son;
    @Autowired
    ReptileSchedule schedule;
    @Autowired
    ReptileScheduleBoy scheduleBoy;
    @Test
    public void te() throws Exception {
        scheduleBoy.climb();
        //schedule.climb();

    }

    @Test
    public void baidu() {
        son.te();
        son.tes();

    }
//
//    @Test
//    public void guba() {
////        getPage("601519", 1);
//        gubaSchedule.getPage("002415", 2);
//        gubaSchedule.getPage("002415", 10);
//        gubaSchedule.getPage("002415", 20);
//        gubaSchedule.getPage("002415", 200);
//        gubaSchedule.getPage("002415", 600);
//    }
//
//    @Test
//    public void thread() {
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println(LocalDateTime.now());
//            }
//        }, 1000, 5000);
//    }
//
//
//    @Test
//    public void te(){
//        Map<String, Object> extraMap =new HashMap<>();
//        try {
//            extraMap.remove("nb");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
