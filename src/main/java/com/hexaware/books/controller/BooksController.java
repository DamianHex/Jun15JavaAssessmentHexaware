package com.hexaware.books.controller;


import com.hexaware.books.model.Book;
import com.hexaware.books.model.Library;
import com.hexaware.books.repository.BooksRepo;
import com.hexaware.books.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BooksRepo booksRepo;

    @Autowired
    private LibraryRepo libraryRepo;

    //create Book
    @PostMapping("/books")
    public Book createBook (@RequestBody Book book) throws Exception{
        try{ booksRepo.save(book);}
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return booksRepo.save(book);
    }

    @PutMapping("/books/{bId}/libraries/{lId}")
    public Book assignBookToLibrary (
            @PathVariable Long bId,
            @PathVariable Long lId
    ) {
            Book book = booksRepo.findById(bId).get();
            Library library = libraryRepo.findById(lId).get();
            book.assignLibrary(library);
            return booksRepo.save(book);
    }

    // Get all books
    @GetMapping("/books")
    public List<Book> getAllBooks (){
        return booksRepo.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id){
        return booksRepo.findById(id).get();
    }

    //Delete Book by Id
    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable Long id){
        booksRepo.delete(booksRepo.findById(id).get());
        return "Deleted Book";
    }


}
