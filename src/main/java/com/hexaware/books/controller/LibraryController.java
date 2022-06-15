package com.hexaware.books.controller;


import com.hexaware.books.controller.model.Books;
import com.hexaware.books.controller.model.Library;
import com.hexaware.books.repository.BooksRepo;
import com.hexaware.books.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private LibraryRepo libraryRepo;

    @Autowired
    private BooksRepo booksRepo;

    @PostMapping("/library")
    public Library createLibrary(@RequestBody Library library){
        return libraryRepo.save(library);
    }

    @GetMapping("/library")
    public List<Library> getAllLibraries(){
        return libraryRepo.findAll();
    }


}
