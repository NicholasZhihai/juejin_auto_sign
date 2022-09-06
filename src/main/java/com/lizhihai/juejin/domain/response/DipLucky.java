package com.lizhihai.juejin.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DipLucky {

    @JsonProperty("err_no")
    private Integer errNo;
    @JsonProperty("err_msg")
    private String errMsg;
    @JsonProperty("data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("dip_action")
        private Integer dipAction;
        @JsonProperty("has_dip")
        private Boolean hasDip;
        @JsonProperty("total_value")
        private Integer totalValue;
        @JsonProperty("dip_value")
        private Integer dipValue;
    }
}
