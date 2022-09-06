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
            "    limit: 5000," +
            "    cursor: \"0\"," +
            "    topic_id: \"6824710202416332807\"" +
            "}";
    public static Cookies lizhihai= new Cookies("_ga=GA1.2.1296772436.1629686778; odin_tt=1bb7f242d137177d63dd9302d566ca5eac4c9fcb56b1dde948623c0efaf17cbecade967d875212a51b1c0e85f5643f2b08907c58b7b23435c0f866d83a18cf6e; __tea_cookie_tokens_2608=%257B%2522user_unique_id%2522%253A%25226999451407582578190%2522%252C%2522web_id%2522%253A%25226999451407582578190%2522%252C%2522timestamp%2522%253A1641781790086%257D; _tea_utm_cache_2608={%22utm_source%22:%22web_feed%22%2C%22utm_medium%22:%22banner%22%2C%22utm_campaign%22:%22trends2022%22}; n_mh=aF0tKUWUyAcHJlDDx97fS0ZhnnMfusA3XPbgj9kIlNU; sid_guard=df0bdb627fd4706207f9a3f778dd7d60%7C1654061612%7C31536000%7CThu%2C+01-Jun-2023+05%3A33%3A32+GMT; uid_tt=f45be1885c7b3d02cc5b411060414d35; uid_tt_ss=f45be1885c7b3d02cc5b411060414d35; sid_tt=df0bdb627fd4706207f9a3f778dd7d60; sessionid=df0bdb627fd4706207f9a3f778dd7d60; sessionid_ss=df0bdb627fd4706207f9a3f778dd7d60; sid_ucp_v1=1.0.0-KGRlMmI1MzExNzMxOTJkZjE3ZmQ0NjY0NWQ1NTU1YWU0YmJhYTY5OWEKFwi93KCx4o2gBRCs9NuUBhiwFDgCQPEHGgJsZiIgZGYwYmRiNjI3ZmQ0NzA2MjA3ZjlhM2Y3NzhkZDdkNjA; ssid_ucp_v1=1.0.0-KGRlMmI1MzExNzMxOTJkZjE3ZmQ0NjY0NWQ1NTU1YWU0YmJhYTY5OWEKFwi93KCx4o2gBRCs9NuUBhiwFDgCQPEHGgJsZiIgZGYwYmRiNjI3ZmQ0NzA2MjA3ZjlhM2Y3NzhkZDdkNjA; MONITOR_WEB_ID=aa936331-59e1-4607-8edf-84657bbc22cd; _gid=GA1.2.1361918968.1659919600");

}
