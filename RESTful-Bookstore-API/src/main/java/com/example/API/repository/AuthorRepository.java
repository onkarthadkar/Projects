package com.example.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.API.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
