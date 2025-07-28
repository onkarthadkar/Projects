package com.example.API.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.API.dto.AuthorRequestDTO;
import com.example.API.dto.AuthorResponseDTO;
import com.example.API.service.AuthorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

	private final AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@PostMapping
	public ResponseEntity<AuthorResponseDTO> createAuthor(@Valid @RequestBody AuthorRequestDTO dto) {
		return ResponseEntity.ok(authorService.createAuthor(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<AuthorResponseDTO> getAuthor(@PathVariable Long id) {
		return ResponseEntity.ok(authorService.getAuthorById(id));
	}

	@GetMapping
	public ResponseEntity<List<AuthorResponseDTO>> getAllAuthors() {
		return ResponseEntity.ok(authorService.getAllAuthors());
	}

	@PutMapping("/{id}")
	public ResponseEntity<AuthorResponseDTO> updateAuthor(@PathVariable Long id,
			@Valid @RequestBody AuthorRequestDTO dto) {
		return ResponseEntity.ok(authorService.updateAuthor(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id);
		return ResponseEntity.noContent().build();
	}
}
