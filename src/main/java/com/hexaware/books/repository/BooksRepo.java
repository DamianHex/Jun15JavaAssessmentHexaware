package com.hexaware.books.repository;

import com.hexaware.books.controller.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BooksRepo extends JpaRepository<Books, Long> {

    }
