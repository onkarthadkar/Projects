package com.example.API.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthorRequestDTO {
    @NotBlank(message = "Author name is mandatory")
    private String name;

    // getters and setters

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
