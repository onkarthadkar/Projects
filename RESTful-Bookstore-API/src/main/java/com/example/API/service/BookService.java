package com.example.API.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.example.API.dto.BookRequestDTO;
import com.example.API.dto.BookResponseDTO;
import com.example.API.entity.Author;
import com.example.API.entity.Book;
import com.example.API.repository.AuthorRepository;
import com.example.API.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookService {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;

	public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public BookResponseDTO createBook(BookRequestDTO dto) {
		Author author = authorRepository.findById(dto.getAuthorId())
				.orElseThrow(() -> new RuntimeException("Author not found"));

		Book book = new Book();
		book.setTitle(dto.getTitle());
		book.setIsbn(dto.getIsbn());
		book.setYearPublished(dto.getYearPublished());
		book.setAuthor(author);

		Book saved = bookRepository.save(book);
		return mapToDTO(saved);
	}

	public BookResponseDTO getBookById(Long id) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		return mapToDTO(book);
	}

	public BookResponseDTO updateBook(Long id, BookRequestDTO dto) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		Author author = authorRepository.findById(dto.getAuthorId())
				.orElseThrow(() -> new RuntimeException("Author not found"));

		book.setTitle(dto.getTitle());
		book.setIsbn(dto.getIsbn());
		book.setYearPublished(dto.getYearPublished());
		book.setAuthor(author);

		Book updated = bookRepository.save(book);
		return mapToDTO(updated);
	}

	public void deleteBook(Long id) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		bookRepository.delete(book);
	}

	// List with filtering by title, paging and sorting
	public Page<BookResponseDTO> listBooks(String title, int page, int size, String sortBy) {
		Pageable pageable = PageRequest.of(page, size, org.springframework.data.domain.Sort.by(sortBy));

		Page<Book> booksPage;
		if (title == null || title.isEmpty()) {
			booksPage = bookRepository.findAll(pageable);
		} else {
			booksPage = bookRepository.findByTitleContainingIgnoreCase(title, pageable);
		}

		return booksPage.map(this::mapToDTO);
	}

	private BookResponseDTO mapToDTO(Book book) {
		return new BookResponseDTO(book.getId(), book.getTitle(), book.getIsbn(), book.getYearPublished(),
				book.getAuthor().getName());
	}
}
