package com.lizhihai.juejin.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class LuckyResponse {
    @JsonProperty("err_no")
    private Integer errNo;
    @JsonProperty("err_msg")
    private String errMsg;
    @JsonProperty("data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("lotteries")
        private List<LotteriesDTO> lotteries;
        @JsonProperty("count")
        private Integer count;

        @NoArgsConstructor
        @Data
        public static class LotteriesDTO {
            @JsonProperty("user_id")
            private String userId;
            @JsonProperty("history_id")
            private String historyId;
            @JsonProperty("user_name")
            private String userName;
            @JsonProperty("user_avatar")
            private String userAvatar;
            @JsonProperty("lottery_name")
            private String lotteryName;
            @JsonProperty("lottery_image")
            private String lotteryImage;
            @JsonProperty("date")
            private Integer date;
            @JsonProperty("dip_lucky_user_count")
            private Integer dipLuckyUserCount;
            @JsonProperty("dip_lucky_users")
            private List<DipLuckyUsersDTO> dipLuckyUsers;

            @NoArgsConstructor
            @Data
            public static class DipLuckyUsersDTO {
                @JsonProperty("user_id")
                private String userId;
                @JsonProperty("user_name")
                private String userName;
                @JsonProperty("avatar_large")
                private String avatarLarge;
            }
        }
    }
}
