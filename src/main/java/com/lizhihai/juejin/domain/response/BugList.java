package com.lizhihai.juejin.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class BugList {

    @JsonProperty("err_no")
    private Integer errNo;
    @JsonProperty("err_msg")
    private String errMsg;
    @JsonProperty("data")
    private List<DataDTO> data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("bug_type")
        private Integer bugType;
        @JsonProperty("bug_time")
        private Integer bugTime;
        @JsonProperty("bug_show_type")
        private Integer bugShowType;
        @JsonProperty("is_first")
        private Boolean isFirst;
    }
}
