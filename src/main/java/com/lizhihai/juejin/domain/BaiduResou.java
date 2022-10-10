package com.lizhihai.juejin.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@Document("resou")
public class BaiduResou {
    private String title;
    private String href;
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private String id;

    public BaiduResou(String title, String href) {
        this.title = title;
        this.href = href;
    }
}
