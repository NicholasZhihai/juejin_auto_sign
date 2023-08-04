package com.lizhihai.juejin.constans;

import com.lizhihai.juejin.domain.Cookies;

public class JuejinApi {
    public static final String POST = "POST";
    public static final String GET = "GET";
    //URL
    //签到
    public static final String CHECK_IN = "https://api.juejin.cn/growth_api/v1/check_in";
    //抽奖
    public static final String DRAW = "https://api.juejin.cn/growth_api/v1/lottery/draw";
    //查询剩余矿石
    public static final String GET_CUR_POINT = "https://api.juejin.cn/growth_api/v1/get_cur_point";
    //查询日历每日文案
    public static final String GET_CODER_CLENDAR = "https://api.juejin.cn/growth_api/v1/get_coder_calendar";
    //查询用户
    public static final String GET_USER = "https://api.juejin.cn/list_api/v1/annual/user_annual";
    //查喜气列表
    public static final String GET_LUCKY="https://api.juejin.cn/growth_api/v1/lottery_history/global_big";
    //沾喜气
    public static final String DIP_LUCKY="https://api.juejin.cn/growth_api/v1/lottery_lucky/dip_lucky";
    //获取bug
    public static final String BUGS="https://api.juejin.cn/user_api/v1/bugfix/not_collect";
    //收集bug
    public static final String COLLECT_BUG="https://api.juejin.cn/user_api/v1/bugfix/collect";
    //相亲角
    public static final String XQJ="https://api.juejin.cn/recommend_api/v1/short_msg/topic?spider=0";
    //评论
    public static final String COMMENT="https://api.juejin.cn/interact_api/v1/comment/publish";
    public static final String xiangQinReq="{" +//查询最新
            "    id_type: 4," +
            "    sort_type: 500," +
            "    limit: 100," +
            "    cursor: \"0\"," +
            "    topic_id: \"6824710202416332807\"" +
            "}";
    
    public static final String xiangQinReq2="{" +
            "    id_type: 4," +
            "    sort_type: 200," +
            "    limit: 50000," +
            "    cursor: \"0\"," +
            "    topic_id: \"6824710202416332807\"" +
            "}";
    public static final String xiangQinReq3="{" +
            "    id_type: 4," +
            "    sort_type: 500," +
            "    limit: 50000," +
            "    cursor: \"0\"," +
            "    topic_id: \"6824710202416332807\"" +
            "}";//sort type  500:最新 200：热门
    public static Cookies lizhihai= new Cookies("_tea_utm_cache_2608=undefined; __tea_cookie_tokens_2608=%7B%22web_id%22%3A%227223587203606677030%22%2C%22user_unique_id%22%3A%227223587203606677030%22%2C%22timestamp%22%3A1681872472652%7D; n_mh=aF0tKUWUyAcHJlDDx97fS0ZhnnMfusA3XPbgj9kIlNU; sid_guard=d276069fa20ce8fd0a9d18c2faab0db4|1681872496|31536000|Thu,+18-Apr-2024+02:48:16+GMT; uid_tt=1dc8d436ab23046dae658a1b8557c526; uid_tt_ss=1dc8d436ab23046dae658a1b8557c526; sid_tt=d276069fa20ce8fd0a9d18c2faab0db4; sessionid=d276069fa20ce8fd0a9d18c2faab0db4; sessionid_ss=d276069fa20ce8fd0a9d18c2faab0db4; sid_ucp_v1=1.0.0-KDJlMzA2MGM0YTJjNTUzMjA4NTBkODkxYTE1YmYzYWY3Y2Q4YzZkOTgKFwi93KCx4o2gBRDwrP2hBhiwFDgHQPQHGgJsZiIgZDI3NjA2OWZhMjBjZThmZDBhOWQxOGMyZmFhYjBkYjQ; ssid_ucp_v1=1.0.0-KDJlMzA2MGM0YTJjNTUzMjA4NTBkODkxYTE1YmYzYWY3Y2Q4YzZkOTgKFwi93KCx4o2gBRDwrP2hBhiwFDgHQPQHGgJsZiIgZDI3NjA2OWZhMjBjZThmZDBhOWQxOGMyZmFhYjBkYjQ; store-region=cn-sh; store-region-src=uid; csrf_session_id=8414b51030d38515af6234fec214d6c7; msToken=FyRyNmtMEmEu-8-RVQnyTVRelYbZKb1y40sqvbuaegm8TYH75WpPywFCFGBSz_KVsN3ZRv1eTcJfVpRspw3wlbrml4bJ2pCWQQcjfmK73dF5HHpqnocbf91zjLppLJE=");

}
