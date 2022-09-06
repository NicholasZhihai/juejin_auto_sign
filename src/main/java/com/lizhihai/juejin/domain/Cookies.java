package com.lizhihai.juejin.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Document("cookies")
public class Cookies {
    private String cookie;
    private String userName;
    private Integer isDelete;
    private String juejinUserId;
    private String ip;
    private boolean drawAll;
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private String id;

    public Cookies(String cookie) {
        this.cookie = cookie;
    }
}
