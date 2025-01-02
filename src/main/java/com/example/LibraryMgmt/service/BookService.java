package com.example.LibraryMgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.example.LibraryMgmt.dto.BookDto;
import com.example.LibraryMgmt.entity.Book;

@Transactional(readOnly = false)
public interface BookService {

	Optional<BookDto> addBook(Book book);

	Optional<BookDto> returnBook(Long bookId, Long membId);

	List<BookDto> getInfoOfAvailableBookInfo();

}
