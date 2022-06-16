package com.hexaware.books.repository;

import com.hexaware.books.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepo extends JpaRepository<Library, Long> {
}
