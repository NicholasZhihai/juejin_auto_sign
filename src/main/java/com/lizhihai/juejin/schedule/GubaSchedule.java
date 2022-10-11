package com.lizhihai.juejin.schedule;

import com.lizhihai.juejin.domain.Guba;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class GubaSchedule {
    @Autowired
    MongoTemplate mongoTemplate;
    @Scheduled(cron = "0 0 12,15 * * ?")
    public void guba() throws Exception {
        getPage("601519",1);
        getPage("002415",1);
    }
    public void getPage(String dsymbol, int page) {
        try {
            String url = "http://guba.eastmoney.com/list," + dsymbol + "_" + page + ".html";
            Document document = Jsoup.connect(url).get();
            Element articleList = document.body().getElementById("articlelistnew");
            for (Node childNode : articleList.childNodes()) {
                if(StringUtils.isBlank(childNode.outerHtml())||articleList.childNodes().indexOf(childNode)<=1){
                    continue;
                }
                String commentCount = childNode.childNode(3).childNode(0).outerHtml();
                String comment = childNode.childNode(5).childNode(0).attr("title");
                String commentUser = childNode.childNode(7).childNode(0).childNode(0).childNode(0).outerHtml();
                String commentTime = childNode.childNode(9).childNode(0).outerHtml();
                String msg = commentTime + "\n股吧用户: " + commentUser + "\n" + comment + "\n评论数：" + commentCount + "\n" + url;
                Guba exist = mongoTemplate.findOne(Query.query(Criteria.where("comment").is(comment)), Guba.class);
                if(exist==null){
                    Guba guba =new Guba(dsymbol,Integer.parseInt(commentCount),comment,commentUser,commentTime);
                    mongoTemplate.save(guba);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
