package com.example.mytestpro.constans.enums;

//cookie 掘金的cookie据说有一个月有效期，挂了就再拷一个过来
public enum Cookies {
    HAI1(false, "小海", "_ga=GA1.2.1296772436.1629686778; MONITOR_WEB_ID=aa936331-59e1-4607-8edf-84657bbc22cd; odin_tt=1bb7f242d137177d63dd9302d566ca5eac4c9fcb56b1dde948623c0efaf17cbecade967d875212a51b1c0e85f5643f2b08907c58b7b23435c0f866d83a18cf6e; n_mh=KF_8KclpLr_zR7cAEjb3RtZNBW4-HCCsXj4xdrmiLXE; __tea_cookie_tokens_2608=%257B%2522user_unique_id%2522%253A%25226999451407582578190%2522%252C%2522web_id%2522%253A%25226999451407582578190%2522%252C%2522timestamp%2522%253A1641781790086%257D; _tea_utm_cache_2608={%22utm_source%22:%22web_feed%22%2C%22utm_medium%22:%22banner%22%2C%22utm_campaign%22:%22trends2022%22}; _gid=GA1.2.1117969153.1646614402; passport_csrf_token_default=2824a4070f9b791b57fa00c1eaccc9f0; passport_csrf_token=2824a4070f9b791b57fa00c1eaccc9f0; _tea_utm_cache_2018=undefined; passport_auth_status=7b8c3dc3b68d2849d5bb83152b235285%2C; passport_auth_status_ss=7b8c3dc3b68d2849d5bb83152b235285%2C; sid_guard=e8927ecdaef4917a8632470732475ae0%7C1646614436%7C5184000%7CFri%2C+06-May-2022+00%3A53%3A56+GMT; uid_tt=894b3e42d349dcbc0bfed9128c14b943; uid_tt_ss=894b3e42d349dcbc0bfed9128c14b943; sid_tt=e8927ecdaef4917a8632470732475ae0; sessionid=e8927ecdaef4917a8632470732475ae0; sessionid_ss=e8927ecdaef4917a8632470732475ae0; sid_ucp_v1=1.0.0-KDRjNGE2ZTRhYTA0MTVkNjI0Njk2MDA4YmY3YWNiNTM4MzM4NDljNGQKFwi93KCx4o2gBRCkr5WRBhiwFDgCQPEHGgJsZiIgZTg5MjdlY2RhZWY0OTE3YTg2MzI0NzA3MzI0NzVhZTA; ssid_ucp_v1=1.0.0-KDRjNGE2ZTRhYTA0MTVkNjI0Njk2MDA4YmY3YWNiNTM4MzM4NDljNGQKFwi93KCx4o2gBRCkr5WRBhiwFDgCQPEHGgJsZiIgZTg5MjdlY2RhZWY0OTE3YTg2MzI0NzA3MzI0NzVhZTA" ),
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
