package com.example.mytestpro.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "age")
    private Integer age;
    @Column(name = "name")
    private String name;
    @Column(name = "school")
    private String school;
    @Column(name = "tel")
    private String tel;

}
