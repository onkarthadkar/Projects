package com.example.API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "ISBN is mandatory")
    @Column(nullable = false, unique = true)
    private String isbn;

    private Integer yearPublished;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    // Constructors, getters, setters

    public Book() {}

    public Book(String title, String isbn, Integer yearPublished, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public Integer getYearPublished() { return yearPublished; }
    public Author getAuthor() { return author; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setYearPublished(Integer yearPublished) { this.yearPublished = yearPublished; }
    public void setAuthor(Author author) { this.author = author; }
}
