package com.loja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
    @Table(name = "category")
    public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false)
        private String name;
        private String description;
        @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
        @JsonIgnore
        private List<Book> books = new ArrayList<>();

    public Category() {
    }

    public Category(List<Book> books, String description, String name, Long id) {
        this.books = books;
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Category category)) return false;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
