package com.example.mytestpro.service;

import com.example.mytestpro.domain.Author;
import com.example.mytestpro.dao.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> findAll() {
        List<Author> authorList = new ArrayList<>();
        authorList = authorRepository.findAll();
        return authorList;
    }
    public Author save(Author author) {
        Author res ;
        res = authorRepository.save(author);
        return res;
    }
}
