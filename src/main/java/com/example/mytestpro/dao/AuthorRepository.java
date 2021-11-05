package com.example.mytestpro.dao;

import com.example.mytestpro.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    public Author findAuthorByAgeAfter(Integer age);
    public Optional<Author> findById(Long id);
    public Optional<Author> findByName(String name);

}
