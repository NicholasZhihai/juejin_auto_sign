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
@Document("guba")
public class Guba {
    private String dsymbol;
    private Integer commentCount;
    private String comment;
    private String commentUser;
    private String commentTime;
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private String id;

    public Guba(String dsymbol, Integer commentCount, String comment, String commentUser, String commentTime) {
        this.dsymbol = dsymbol;
        this.commentCount = commentCount;
        this.comment = comment;
        this.commentUser = commentUser;
        this.commentTime = commentTime;
    }
}
