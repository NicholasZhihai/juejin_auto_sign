package com.example.mytestpro;

import com.example.mytestpro.mongodb.Author;
import com.example.mytestpro.util.MongodbUtil;
import com.example.mytestpro.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootTest
class MyTestProApplicationTests {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    MongoTemplate mongoTemplate;


    @Test
    void contextLoads() {
        Author author=new Author();
        author.setId(1L);
        author.setAge(22);
        author.setName("lizhihai");
        author.setCity("shanghai");
        author.setEducation("undergraduate");
        author.setJob("java software engineering");
        author.setSex(1);
        author.setHobby("I love java and vue.js");
        mongoTemplate.save(author);
//        List<Author> all = mongoTemplate.findAll(Author.class);
//        System.out.println(all);
        List<Author> findd = (List<com.example.mytestpro.mongodb.Author>) MongodbUtil.find(new Author(), new String[]{"age"}, new Integer[]{12});
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(21));
        List<Author> authors = mongoTemplate.find(query, Author.class);
        System.out.println(authors);
    }

}
