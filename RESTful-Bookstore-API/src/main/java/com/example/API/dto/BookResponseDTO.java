package com.example.API.dto;

public class BookResponseDTO {

    private Long id;
    private String title;
    private String isbn;
    private Integer yearPublished;
    private String authorName;

    public BookResponseDTO(Long id, String title, String isbn, Integer yearPublished, String authorName) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.yearPublished = yearPublished;
        this.authorName = authorName;
    }

    // getters

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public Integer getYearPublished() { return yearPublished; }
    public String getAuthorName() { return authorName; }
}

