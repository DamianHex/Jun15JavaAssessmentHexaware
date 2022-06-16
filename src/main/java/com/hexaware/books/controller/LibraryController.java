package com.hexaware.books.controller;


import com.hexaware.books.model.Book;
import com.hexaware.books.model.Library;
import com.hexaware.books.repository.BooksRepo;
import com.hexaware.books.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class LibraryController {

    @Autowired
    private LibraryRepo libraryRepo;

    @Autowired
    private BooksRepo booksRepo;

    //create
    @PostMapping("/libraries")
    public Library createLibrary(@RequestBody Library library){
        return libraryRepo.save(library);
    }

    // read
    @GetMapping("/libraries")
    public List<Library> getAllLibraries() {
        return libraryRepo.findAll();
    }

    // get by id
    @GetMapping("/libraries/{id}")
    public Library getLibraryById(@PathVariable Long id){
        return libraryRepo.findById(id).get();
    }

    // delete
    @DeleteMapping("/libraries/{id}")
    public String deleteLibraryById(@PathVariable Long id) {
        libraryRepo.delete(libraryRepo.findById(id).get());
        return "Deleted Library";
    }

    //get book count by library
    @GetMapping("/library/{libraryId}/count")
    public Long bookcount(@PathVariable Long libraryId){
        Library library = libraryRepo.findById(libraryId).get();
        long booksSet = library.getBooksSet().stream().count();
        return booksSet;
    }

    //display all books in each library
    @GetMapping("/library/{libraryId}/books")
    public Set<Book> allBooksByLibraryId(@PathVariable Long libraryId){
        Library library = libraryRepo.findById(libraryId).get();
        return library.getBooksSet();
    }

}
