package com.loja.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @JsonFormat(pattern = "DD/MM/YYYY" )
    private LocalDate launchDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    public Book() {
    }

    public Book(Long id, String title, BigDecimal price, LocalDate launchDate, Author author, Category category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.launchDate = launchDate;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
