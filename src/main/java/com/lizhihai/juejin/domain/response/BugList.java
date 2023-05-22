package com.lizhihai.juejin.domain.response;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class BugList {

     @JSONField(name = "err_no")
    private Integer errNo;
     @JSONField(name = "err_msg")
    private String errMsg;
     @JSONField(name = "data")
    private List<DataDTO> data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
         @JSONField(name = "bug_type")
        private Integer bugType;
         @JSONField(name = "bug_time")
        private Integer bugTime;
         @JSONField(name = "bug_show_type")
        private Integer bugShowType;
         @JSONField(name = "is_first")
        private Boolean isFirst;
    }
}
