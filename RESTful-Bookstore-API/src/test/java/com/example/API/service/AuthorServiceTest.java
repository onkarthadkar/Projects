package com.example.API.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.API.dto.AuthorRequestDTO;
import com.example.API.dto.AuthorResponseDTO;

@SpringBootTest
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    public void testCreateAuthor() {
        AuthorRequestDTO dto = new AuthorRequestDTO();
        dto.setName("Stephen King");

        AuthorResponseDTO response = authorService.createAuthor(dto);

        assertThat(response).isNotNull();
        assertThat(response.getId()).isNotNull();
        assertThat(response.getName()).isEqualTo(dto.getName());
    }

    @Test
    public void testGetAuthorNotFound() {
        Long invalidId = 99999L;
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> authorService.getAuthorById(invalidId));
        assertThat(ex.getMessage()).contains("Author not found");
    }
}
