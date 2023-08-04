package com.lizhihai.juejin.util;

import com.alibaba.fastjson2.JSON;
import com.lizhihai.juejin.constans.QYWX;
import com.lizhihai.juejin.schedule.DrawSchedule;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lizhihai
 * @date 2023/8/2
 * @description
 */
@Service
public class QYWXUtil {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    private final static Logger logger = LoggerFactory.getLogger(QYWXUtil.class);

    public void sendMarkDown(String content, List<String> AtList, String linkUrl) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> markdown = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String mdContent = sb.append("###### 相亲角来报\n")
                .append("\n")
                .append(" ######  [详情](")
                .append(linkUrl)
                .append(")")
                .append("\n")
                .append(content).toString();
        markdown.put("mentioned_mobile_list", "@" + String.join("@", AtList));
        markdown.put("content", mdContent);
        map.put("msgtype", "markdown");
        map.put("markdown", markdown);
        doPost(QYWX.ROBOT, new HashMap<>(), JSON.toJSONString(map));
    }

    public void sendPicture(String content, String url, List<String> pictureList) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> articles = new HashMap<>();
        articles.put("title", content.length() > 10 ? content.substring(0, 10) : content);
        articles.put("description", content);
        articles.put("url", url);
        articles.put("picurl", pictureList.get(0));
        map.put("msgtype", "news");
        Map<String, Object> amap = new HashMap<>();
        amap.put("articles", Arrays.asList(articles));
        map.put("news", amap);
        doPost(QYWX.ROBOT, new HashMap<>(), JSON.toJSONString(map));
    }

    public String doPost(String url, Map<String, String> headers, String body) {
        String httpCharset = "utf-8";
        // 创建HttpClient对象

        // 创建HttpResponse对象
        CloseableHttpResponse response = null;
        logger.info("request param info : {}", body);
        logger.info("request header info : {}", headers);
        try {
            try {
                // 创建HttpPost对象
                HttpPost post = new HttpPost(url);
                // 封装请求头
                if (null != headers) {
                    headers.keySet().forEach(key -> {
                        post.addHeader(key, headers.get(key));
                    });
                }
                post.addHeader(HTTP.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                // 封装请求体
                if (StringUtils.isNotBlank(body)) {
                    // 请求体主要封装在HttpEntity中
                    post.setEntity(new StringEntity(body, Charset.forName(httpCharset)));
                }

                response = httpClient.execute(post);
                // 处理响应
                String result = EntityUtils.toString(response.getEntity(), Charset.forName(httpCharset));
                logger.info("response info : {}", result);
            } catch (IOException e) {
                logger.error("post链接失败：" + e.getMessage());
            } finally {
                // 释放连接
                response.close();
            }
        } catch (IOException e) {
            logger.error("post关闭response失败：" + e.getMessage());
        }
        return null;
    }
}
