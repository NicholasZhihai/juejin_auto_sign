package com.lizhihai.juejin.domain.response;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DrawResponse {

     @JSONField(name = "err_no")
    private Integer errNo;
     @JSONField(name = "err_msg")
    private String errMsg;
     @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
         @JSONField(name = "id")
        private Integer id;
         @JSONField(name = "lottery_id")
        private String lotteryId;
         @JSONField(name = "lottery_name")
        private String lotteryName;
         @JSONField(name = "lottery_type")
        private Integer lotteryType;
         @JSONField(name = "lottery_image")
        private String lotteryImage;
         @JSONField(name = "history_id")
        private String historyId;
    }
}
