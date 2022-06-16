package com.hexaware.books.repository;

import com.hexaware.books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository<Book, Long> {

    }
