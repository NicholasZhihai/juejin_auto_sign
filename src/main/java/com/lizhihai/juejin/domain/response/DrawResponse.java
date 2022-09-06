package com.lizhihai.juejin.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DrawResponse {

    @JsonProperty("err_no")
    private Integer errNo;
    @JsonProperty("err_msg")
    private String errMsg;
    @JsonProperty("data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("lottery_id")
        private String lotteryId;
        @JsonProperty("lottery_name")
        private String lotteryName;
        @JsonProperty("lottery_type")
        private Integer lotteryType;
        @JsonProperty("lottery_image")
        private String lotteryImage;
        @JsonProperty("history_id")
        private String historyId;
    }
}
