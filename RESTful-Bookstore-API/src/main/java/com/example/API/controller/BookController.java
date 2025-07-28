package com.example.API.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.API.dto.BookRequestDTO;
import com.example.API.dto.BookResponseDTO;
import com.example.API.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping
	public ResponseEntity<BookResponseDTO> createBook(@Valid @RequestBody BookRequestDTO dto) {
		return ResponseEntity.ok(bookService.createBook(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookResponseDTO> getBook(@PathVariable Long id) {
		return ResponseEntity.ok(bookService.getBookById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookRequestDTO dto) {
		return ResponseEntity.ok(bookService.updateBook(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<Page<BookResponseDTO>> listBooks(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "title") String sortBy) {
		return ResponseEntity.ok(bookService.listBooks(title, page, size, sortBy));
	}
}
