package com.lizhihai.juejin.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@Data
public class CalendarResponse {

    @JsonProperty("err_no")
    private Integer errNo;
    @JsonProperty("err_msg")
    private String errMsg;
    @JsonProperty("data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("aphorism")
        private String aphorism;
        @JsonProperty("should_or_not")
        private String shouldOrNot;
        @Override
        public String toString(){
            Date now= new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr=sdf.format(now);
            return dateStr+" | "+shouldOrNot+" | "+aphorism;
        }
    }
}
