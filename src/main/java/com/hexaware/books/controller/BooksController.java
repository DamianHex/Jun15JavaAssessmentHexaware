package com.hexaware.books.controller;


import com.hexaware.books.controller.model.Books;
import com.hexaware.books.controller.model.Library;
import com.hexaware.books.repository.BooksRepo;
import com.hexaware.books.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Set;

@RestController
public class BooksController {

    @Autowired
    private BooksRepo booksRepo;

    @Autowired
    private LibraryRepo libraryRepo;

    @PostMapping("/books")
    public Books createBook (@RequestBody Books book){
        return booksRepo.save(book);
    }


    @PutMapping("books/{bookId}/library/{libraryId}")
    Books assignLibraryToBook(
            @PathVariable String bookId,
            @PathVariable String libraryId
    ) {
        Long bookId2 = Long.parseLong(bookId);
        Long libraryId2 = Long.parseLong(libraryId);

        Books book = booksRepo.findById(bookId2).get();
        Library library = libraryRepo.findById(libraryId2).get();
        book.setLibrary(library);
        return booksRepo.save(book);
    }

    @GetMapping("/library/count")
    public Long bookcount(){
        Library library = null;
        long booksSet = library.getBooks().stream().count();
        return booksSet;
    }

    @GetMapping("/books")
    public List<Books> getAllBooks (){
        return booksRepo.findAll();
    }


}
