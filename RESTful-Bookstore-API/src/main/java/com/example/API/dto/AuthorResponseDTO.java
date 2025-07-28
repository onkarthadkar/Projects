package com.example.API.dto;

public class AuthorResponseDTO {
    private Long id;
    private String name;

    public AuthorResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters

    public Long getId() { return id; }
    public String getName() { return name; }
}
