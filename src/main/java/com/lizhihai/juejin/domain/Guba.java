package com.lizhihai.juejin.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.CollectionUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Document("guba")
public class Guba {
    private String dsymbol;
    private Integer commentCount;
    private String comment;
    private String commentUser;
    private String commentTime;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    public Guba(String dsymbol, Integer commentCount, String comment, String commentUser, String commentTime) {
        this.dsymbol = dsymbol;
        this.commentCount = commentCount;
        this.comment = comment;
        this.commentUser = commentUser;
        this.commentTime = commentTime;
    }

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            data.add(i);
        }
        System.out.println(Arrays.toString(intervalSampling(data, 17).toArray()));
        System.out.println(Arrays.toString(intervalSampling(data, 3).toArray()));
        System.out.println(Arrays.toString(intervalSampling(data, 8).toArray()));
        System.out.println(Arrays.toString(intervalSampling(data, 10).toArray()));
    }

    /**
     * @param maxSize 抽取样本数量
     * @param data    有序的原始数据
     * @return 返回抽样后的精简数据
     * @description 走势图间隔抽样 业务一般都希望能看到最新一天的涨幅情况，所有可以默认就把最后一天的数据放入样本最后
     */
    public static <T> List<T> intervalSampling(List<T> data, int maxSize) {
        if (CollectionUtils.isEmpty(data)) {
            return new ArrayList<>();
        }
        if (data.size() <= maxSize) {
            return data;
        }
        List<T> sampleList = new ArrayList<>();
        float stepSize = (data.size() - 1f) / (maxSize - 1f);
        for (float i = 0; i < data.size() - 1; i = i + stepSize) {
            sampleList.add(data.get(Math.round(i)));
        }
        sampleList.add(data.get(data.size() - 1));
        return sampleList;
    }

}
