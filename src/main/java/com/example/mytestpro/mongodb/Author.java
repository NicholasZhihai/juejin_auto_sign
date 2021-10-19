package com.example.mytestpro.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document("author")
public class Author {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private Integer sex;
    private String education;
    private String job;
    private String city;
    private String hobby;
}
