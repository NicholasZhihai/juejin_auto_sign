package com.lizhihai.juejin.domain.response;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@Data
public class CalendarResponse {

     @JSONField(name = "err_no")
    private Integer errNo;
     @JSONField(name = "err_msg")
    private String errMsg;
     @JSONField(name = "data")
    private DataDTO data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
         @JSONField(name = "aphorism")
        private String aphorism;
         @JSONField(name = "should_or_not")
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
