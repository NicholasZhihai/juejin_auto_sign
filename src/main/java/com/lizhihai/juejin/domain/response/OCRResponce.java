package com.lizhihai.juejin.domain.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lizhihai
 * @date 2023/8/18
 * @description
 */
@NoArgsConstructor
@Data
public class OCRResponce {


    @JSONField(name = "words_result")
    private List<WordsResultDTO> wordsResult;
    @JSONField(name = "words_result_num")
    private Integer wordsResultNum;
    @JSONField(name = "log_id")
    private Long logId;

    @NoArgsConstructor
    @Data
    public static class WordsResultDTO {
        @JSONField(name = "words")
        private String words;
    }
}
