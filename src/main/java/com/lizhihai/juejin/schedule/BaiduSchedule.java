package com.lizhihai.juejin.schedule;

import com.lizhihai.juejin.domain.BaiduResou;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class BaiduSchedule {
    @Autowired
    MongoTemplate mongoTemplate;
    @Scheduled(cron = "0 0 8,12,16,20 * * ?")
    public void refresh() {
        try {
            String url = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=601519";
            Document document = Jsoup.connect(url).get();
            Node articleList = document.body().getElementsByClass("FYB_RD").get(0).childNodes().get(1);
            for (Node childNode : articleList.childNode(0).childNodes()) {
                saveResou(childNode);
            }
            for (Node childNode : articleList.childNode(1).childNodes()) {
                saveResou(childNode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveResou(Node childNode) {
        String href = childNode.childNode(0).childNode(1).attr("href");
        String title = childNode.childNode(0).childNode(1).attr("title");
        BaiduResou exist = mongoTemplate.findOne(Query.query(Criteria.where("title").is(title)), BaiduResou.class);
        if(exist==null){
            BaiduResou resou =new BaiduResou(title,"https://www.baidu.com"+href);
            mongoTemplate.save(resou);
        }
    }
}
