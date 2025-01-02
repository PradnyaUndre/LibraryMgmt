package com.example.LibraryMgmt.util;

import static com.example.LibraryMgmt.dtoMapper.BookMapper.TO_BOOK_MASTER;

import org.springframework.stereotype.Component;

import com.example.LibraryMgmt.dto.BookDto;
import com.example.LibraryMgmt.entity.Book;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class BookUtil {

	public Book toBook(BookDto bookDto) throws Exception {
		Book book = TO_BOOK_MASTER.apply(bookDto)
				.orElseThrow(() -> new Exception("Unable to convert book dto into book entity."));
		return book;

	}

}
