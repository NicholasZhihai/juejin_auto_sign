package com.example.mytestpro.service;

import com.alibaba.fastjson.JSON;
import com.example.mytestpro.constans.Constans;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/**
 * @Author: zhouhe
 * @Date: 2019/6/20 14:49
 */
@Service
public class SendHttps {
    private static Logger logger = LoggerFactory.getLogger(SendHttps.class);
    /**
     * 发送POST请求，参数是Map,contentType=x-www-form-urlencoded
     *
     * @param url
     * @param mapParam
     * @return
     */
    public static String sendPostByMap(String url,Map<String,Object> mapParam) {
        Map<String,String> headParam = new HashMap();
        headParam.put("Content-type","application/json;charset=UTF-8");
        return sendPost(url,mapParam,headParam);
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url  发送请求的 URL
     * @param param 请求参数，
     * @param headParam
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, Object param, Map<String, String> headParam) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性 请求头
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setRequestProperty("user-agent","Fiddler");

            if (headParam != null) {
                for (Entry<String,String> entry : headParam.entrySet()) {
                    conn.setRequestProperty(entry.getKey(),entry.getValue());
                }
            }
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(JSON.toJSONString(param));
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.info("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送信息到钉钉  参考https://www.cnblogs.com/fugitive/p/14041824.html
     * @throws Exception
     */
    public void sendToDingDing(String message)throws Exception{
        // 钉钉的webhook
        String dingDingToken= Constans.DINGDINGTOKEN;

        //还需要加签，参考  https://developers.dingtalk.com/document/robots/customize-robot-security-settings  这里鬼知道为啥过不了验证，就改成公网ip校验了
        //参考https://developers.dingtalk.com/document/robots/customize-robot-security-settings

        dingDingToken=dingDingToken;//+getSign();
        // 请求的JSON数据，这里我用map在工具类里转成json格式
        Map<String,Object> json=new HashMap();
        Map<String,Object> text=new HashMap();
        json.put("msgtype","text");
        text.put("content",message);
        json.put("text",text);
        // 发送post请求
        String response = SendHttps.sendPostByMap(dingDingToken,json);
        System.out.println("相应结果："+response);
    }

    /**
     * 钉钉官网上配置机器人获取签名，太麻烦，就改成ip方式安全验证了
     * @return
     * @throws Exception
     */
    public String getSign()throws Exception{
        Long timestamp = System.currentTimeMillis();
        String secret = "this is secret";

        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
        System.out.println(sign);
        return "&timestamp="+ timestamp +"&sign="+sign;
    }
}