package com.hexaware.books.controller.model;


import javax.persistence.*;

@Entity
public class Books {
    @Id
    private String id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "library_id", referencedColumnName = "id")
    private Library library;

    public Books() {
    }

    public Library getLibrary() {
        return library;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
