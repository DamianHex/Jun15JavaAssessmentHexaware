package com.hexaware.books.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String id2;
    @Column
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "library")
    private Set<Book> booksSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooksSet() {
        return booksSet;
    }

    public void setBooksSet(Set<Book> booksSet) {
        this.booksSet = booksSet;
    }

    public void setBooks(Set<Book> books) {
        this.booksSet = booksSet;
    }
}
