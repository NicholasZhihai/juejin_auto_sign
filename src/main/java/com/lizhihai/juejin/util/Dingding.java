package com.lizhihai.juejin.util;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Arrays;

import static com.lizhihai.juejin.constans.DingdingConfig.DINGDINGTOKEN;

@Service
public class Dingding {
    private static Logger logger = LoggerFactory.getLogger(Dingding.class);
    @Test
    public void test() throws ApiException {
        send("快马来报！","666","https://juejin.cn/user/"+"2955960342031933"+"/pins","18390921146","sss");
    }
    public void send(String title,String content,String linkUrl,String messageId,String ... atPhone) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(DINGDINGTOKEN);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(Arrays.asList(atPhone));
        request.setAt(at);
        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle(title);
        markdown.setText("#### "+"@"+String.join("@",atPhone)+" \n" +
                ">  " +content+"\n"+
                "> ######  [点击发起评论抢占先机]("+"http://localhost:10086/juejin/commentGirl?aim="+messageId+"&comment=恭喜你,通过亚洲舞王阿海的初审,请速速与我详细私聊) \n"+
                "> ######  [主页详情]("+linkUrl+") \n");
        request.setMarkdown(markdown);
        OapiRobotSendResponse response = client.execute(request);
    }
    public void send(String content) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(DINGDINGTOKEN);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(content);
        request.setText(text);
        OapiRobotSendResponse response = client.execute(request);
    }
}