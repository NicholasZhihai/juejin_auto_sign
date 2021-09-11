**掘金自动签到并抽奖发送到钉钉**

**1.**关键词：springboot，钉钉，https，掘金,COOKIE

**2.**目录介绍 

constants

定义了掘金抽奖、签到等api的url，**以及掘金的cookies（到浏览器找一下改成自己的）**

mainschedule

主要定时任务类 逻辑每天零点一分签到并免费抽奖一次，当allin标记开启为true时，只要还能抽就梭哈，直到不足200矿石，想攒钻石就自己改成false，想换时间就改一下cron

sendhttps

发送钉钉消息类

cookieenum
需要帮多个人签到抽奖的话就在这里把cookie加一下就行啦

钉钉有三种机器人安全方式，一种是关键字，一种是加签名，一种是ip拦截

[自定义机器人安全设置 - 钉钉开放平台 (dingtalk.com)](https://developers.dingtalk.com/document/robots/customize-robot-security-settings)

这里我用最后一种，如何对接钉钉参考，需要使用pc端，https://www.cnblogs.com/fugitive/p/14041824.html

记得改constans里的钉钉机器人token为自己设置的机器人

记得选择ip方式，然后到[iP地址查询--手机号码查询归属地 | 邮政编码查询 | iP地址归属地查询 | 身份证号码验证在线查询网 (ip138.com)](https://ip138.com/)

查询自己本机的公网ip（不是ipconfig的局域网）设置钉钉机器人，我这里是每次抽奖都会发送到群消息，如果嫌半夜吵可以全局搜索sendHttps.sendToDingDing 注释掉



**3.**掘金api参考了github里搜的掘金自动签到里收藏最多那个，这会儿没墙就不贴网址了

对接钉钉参考了https://www.jb51.cc/java/526453.html  代码作者zhouhe 感谢



2021.09.10 lizhihai @shanghai @qq786710726



