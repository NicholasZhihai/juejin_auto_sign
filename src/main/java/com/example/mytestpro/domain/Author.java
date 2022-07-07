package com.example.mytestpro.domain;

import com.example.mytestpro.config.privacy.Privacy;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "age")
    private Integer age;
    @Privacy(preLen = 1,sufLen = 0)
    @Column(name = "name")
    private String name;
    @Column(name = "school")
    private String school;
    @Column(name = "tel")
    private String tel;

}
