package com.lizhihai.juejin.domain.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DipLucky {

    @JSONField(name = "err_no")
    private Integer errNo;
     @JSONField(name = "err_msg")
    private String errMsg;
     @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
         @JSONField(name = "dip_action")
        private Integer dipAction;
         @JSONField(name = "has_dip")
        private Boolean hasDip;
         @JSONField(name = "total_value")
        private Integer totalValue;
         @JSONField(name = "dip_value")
        private Integer dipValue;
    }
}
