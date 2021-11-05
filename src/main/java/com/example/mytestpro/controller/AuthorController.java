package com.example.mytestpro.controller;

import com.example.mytestpro.domain.Author;
import com.example.mytestpro.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/Author")
public class AuthorController {
    private final static Logger logger = LoggerFactory.getLogger(AuthorController.class);
    @Autowired
    AuthorService authorService;

    @ResponseBody
    @RequestMapping("/findAll")
    public List<Author> getCookie() {
        return authorService.findAll();
    }
    @ResponseBody
    @RequestMapping("/saveOne")
    public Author save(@RequestBody Author author) {
        return authorService.save(author);
    }
}
