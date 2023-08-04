package com.lizhihai.juejin.domain.response;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Document("girl")
@Data
public class Girl {
    private String linkUrl;
    private String home;
    private List<String> picList;
    private String content;
    private String birth;
    private String city;
    private String vx;
    private String height;
    private String weight;
    private String juejinAccount;
    private boolean valid =false;
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private String id;
    private Integer nice=0;
}
