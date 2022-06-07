package com.example.mytestpro.constans.enums;

//cookie 掘金的cookie据说有一个月有效期，挂了就再拷一个过来
public enum Cookies {
    HAI1(false, "小海", "_ga=GA1.2.1296772436.1629686778; MONITOR_WEB_ID=aa936331-59e1-4607-8edf-84657bbc22cd; odin_tt=1bb7f242d137177d63dd9302d566ca5eac4c9fcb56b1dde948623c0efaf17cbecade967d875212a51b1c0e85f5643f2b08907c58b7b23435c0f866d83a18cf6e; __tea_cookie_tokens_2608=%257B%2522user_unique_id%2522%253A%25226999451407582578190%2522%252C%2522web_id%2522%253A%25226999451407582578190%2522%252C%2522timestamp%2522%253A1641781790086%257D; _tea_utm_cache_2608={%22utm_source%22:%22web_feed%22%2C%22utm_medium%22:%22banner%22%2C%22utm_campaign%22:%22trends2022%22}; _gid=GA1.2.2081409664.1654061585; passport_csrf_token=d918aa05875d47e029b0d0196c172cf2; passport_csrf_token_default=d918aa05875d47e029b0d0196c172cf2; _tea_utm_cache_2018=undefined; n_mh=aF0tKUWUyAcHJlDDx97fS0ZhnnMfusA3XPbgj9kIlNU; passport_auth_status=00729f32bfccf033d2fff1e00711cafc%2C; passport_auth_status_ss=00729f32bfccf033d2fff1e00711cafc%2C; sid_guard=df0bdb627fd4706207f9a3f778dd7d60%7C1654061612%7C31536000%7CThu%2C+01-Jun-2023+05%3A33%3A32+GMT; uid_tt=f45be1885c7b3d02cc5b411060414d35; uid_tt_ss=f45be1885c7b3d02cc5b411060414d35; sid_tt=df0bdb627fd4706207f9a3f778dd7d60; sessionid=df0bdb627fd4706207f9a3f778dd7d60; sessionid_ss=df0bdb627fd4706207f9a3f778dd7d60; sid_ucp_v1=1.0.0-KGRlMmI1MzExNzMxOTJkZjE3ZmQ0NjY0NWQ1NTU1YWU0YmJhYTY5OWEKFwi93KCx4o2gBRCs9NuUBhiwFDgCQPEHGgJsZiIgZGYwYmRiNjI3ZmQ0NzA2MjA3ZjlhM2Y3NzhkZDdkNjA; ssid_ucp_v1=1.0.0-KGRlMmI1MzExNzMxOTJkZjE3ZmQ0NjY0NWQ1NTU1YWU0YmJhYTY5OWEKFwi93KCx4o2gBRCs9NuUBhiwFDgCQPEHGgJsZiIgZGYwYmRiNjI3ZmQ0NzA2MjA3ZjlhM2Y3NzhkZDdkNjA" ),
    HAI2(false, "小海亡命高科西", "MONITOR_WEB_ID=46e596ce-9ecc-4a89-992a-7c6a6e0c3481; _ga=GA1.2.1129485207.1631332210; _gid=GA1.2.1280463638.1631332210; passport_csrf_token_default=79180cb48bf4906a01362c777619a03e; passport_csrf_token=79180cb48bf4906a01362c777619a03e; passport_auth_status=26b44631a00ffda2ca525997e425471b%2C; passport_auth_status_ss=26b44631a00ffda2ca525997e425471b%2C; sid_guard=da5b5f8fa2be84a74656f9ed8f0f58de%7C1631332246%7C5184000%7CWed%2C+10-Nov-2021+03%3A50%3A46+GMT; uid_tt=369af9b9a6bd0a458166702eb1a9eb76; uid_tt_ss=369af9b9a6bd0a458166702eb1a9eb76; sid_tt=da5b5f8fa2be84a74656f9ed8f0f58de; sessionid=da5b5f8fa2be84a74656f9ed8f0f58de; sessionid_ss=da5b5f8fa2be84a74656f9ed8f0f58de; sid_ucp_v1=1.0.0-KDA2ODRmYTJmODZiOThjYjBjNDhjYjZjYzMwZjY0NzNhNzM1ODdhYmIKFwjnkrCFu4yWAxCWz_CJBhiwFDgCQPEHGgJsZiIgZGE1YjVmOGZhMmJlODRhNzQ2NTZmOWVkOGYwZjU4ZGU; ssid_ucp_v1=1.0.0-KDA2ODRmYTJmODZiOThjYjBjNDhjYjZjYzMwZjY0NzNhNzM1ODdhYmIKFwjnkrCFu4yWAxCWz_CJBhiwFDgCQPEHGgJsZiIgZGE1YjVmOGZhMmJlODRhNzQ2NTZmOWVkOGYwZjU4ZGU; n_mh=gY-EUdc0-atNYE3DFtWTsH7CHt0JMgKQkRnBimbpdn8; _gat=1"),
    ;
    private String name;//名字
    private String value;//cookie，自己上浏览器粘贴过来
    private boolean isAllIn;//是否梭哈

    Cookies(boolean isAllIn, String name, String value) {
        this.isAllIn = isAllIn;
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public boolean isAllIn() {
        return isAllIn;
    }

    public String getValue() {
        return value;
    }
}
