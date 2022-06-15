package com.hexaware.books.controller.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Library {
    @Id
    private String id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "library")
    private Set<Books> books;

    public Library() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Books> getBooks() {
        return books;
    }

}
