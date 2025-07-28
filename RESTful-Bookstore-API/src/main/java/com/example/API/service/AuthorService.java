package com.example.API.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.API.dto.AuthorRequestDTO;
import com.example.API.dto.AuthorResponseDTO;
import com.example.API.entity.Author;
import com.example.API.repository.AuthorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthorService {

	private final AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public AuthorResponseDTO createAuthor(AuthorRequestDTO dto) {
		Author author = new Author();
		author.setName(dto.getName());
		Author saved = authorRepository.save(author);
		return mapToDTO(saved);
	}

	public AuthorResponseDTO getAuthorById(Long id) {
		Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
		return mapToDTO(author);
	}

	public List<AuthorResponseDTO> getAllAuthors() {
		return authorRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO dto) {
		Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
		author.setName(dto.getName());
		Author updated = authorRepository.save(author);
		return mapToDTO(updated);
	}

	public void deleteAuthor(Long id) {
		Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
		authorRepository.delete(author);
	}

	// Mapper method
	private AuthorResponseDTO mapToDTO(Author author) {
		return new AuthorResponseDTO(author.getId(), author.getName());
	}
}
