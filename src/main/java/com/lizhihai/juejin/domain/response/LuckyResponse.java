package com.lizhihai.juejin.domain.response;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class LuckyResponse {
     @JSONField(name = "err_no")
    private Integer errNo;
     @JSONField(name = "err_msg")
    private String errMsg;
     @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
         @JSONField(name = "lotteries")
        private List<LotteriesDTO> lotteries;
         @JSONField(name = "count")
        private Integer count;

        @NoArgsConstructor
        @Data
        public static class LotteriesDTO {
             @JSONField(name = "user_id")
            private String userId;
             @JSONField(name = "history_id")
            private String historyId;
             @JSONField(name = "user_name")
            private String userName;
             @JSONField(name = "user_avatar")
            private String userAvatar;
             @JSONField(name = "lottery_name")
            private String lotteryName;
             @JSONField(name = "lottery_image")
            private String lotteryImage;
             @JSONField(name = "date")
            private Integer date;
             @JSONField(name = "dip_lucky_user_count")
            private Integer dipLuckyUserCount;
             @JSONField(name = "dip_lucky_users")
            private List<DipLuckyUsersDTO> dipLuckyUsers;

            @NoArgsConstructor
            @Data
            public static class DipLuckyUsersDTO {
                 @JSONField(name = "user_id")
                private String userId;
                 @JSONField(name = "user_name")
                private String userName;
                 @JSONField(name = "avatar_large")
                private String avatarLarge;
            }
        }
    }
}
