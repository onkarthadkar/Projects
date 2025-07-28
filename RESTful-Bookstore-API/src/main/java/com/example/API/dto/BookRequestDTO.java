package com.example.API.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookRequestDTO {

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "ISBN is mandatory")
    private String isbn;

    private Integer yearPublished;

    @NotNull(message = "Author ID is required")
    private Long authorId;

    // getters and setters

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Integer getYearPublished() { return yearPublished; }
    public void setYearPublished(Integer yearPublished) { this.yearPublished = yearPublished; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }
}
