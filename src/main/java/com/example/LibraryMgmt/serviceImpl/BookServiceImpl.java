package com.example.LibraryMgmt.serviceImpl;

import static com.example.LibraryMgmt.dtoMapper.BookMapper.TO_BOOK;
import static com.example.LibraryMgmt.dtoMapper.BookMapper.TO_BOOK_LIST;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.LibraryMgmt.dto.BookDto;
import com.example.LibraryMgmt.entity.Book;
import com.example.LibraryMgmt.entity.TakeBook;
import com.example.LibraryMgmt.repository.BookRepo;
import com.example.LibraryMgmt.repository.TakeBookRepo;
import com.example.LibraryMgmt.service.BookService;
import com.example.LibraryMgmt.service.TakeBookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookRepo bookRepo;
	private final TakeBookService takeBookService;
	private final TakeBookRepo takeBookRepo;

	@Override
	public Optional<BookDto> addBook(Book book) {
		System.out.println("In save......");
		book.setStatus("available");
		return TO_BOOK.apply(bookRepo.save(book));
	}

	@Override
	public Optional<BookDto> returnBook(Long bookId , Long membId) {
		
		Optional<TakeBook> takeBook = takeBookRepo.findByBookBookIdAndMemberMasterMembId(bookId, membId);
		if (takeBook.isPresent()) {
			System.out.println("take book status yes");
			takeBook.get().setIsReturn("Yes");
			takeBookRepo.save(takeBook.get());
		}
		System.out.println("-------------return book------");
		Optional<Book> book = bookRepo.findById(bookId);
		if (book.isPresent()) {
			System.out.println("Set available");
			book.get().setStatus("available");
			//return TO_BOOK.apply(bookRepo.save(book.get()));
		}
		return Optional.empty();
	}

	@Override
	public List<BookDto> getInfoOfAvailableBookInfo() {
		List<Book> bookList = bookRepo.findAllByStatus("available");
		return TO_BOOK_LIST.apply(bookList);
	}

}
