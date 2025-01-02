package com.example.LibraryMgmt.serviceImpl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.LibraryMgmt.dto.TakeBookDto;
import com.example.LibraryMgmt.entity.Book;
import com.example.LibraryMgmt.entity.TakeBook;
import com.example.LibraryMgmt.repository.BookRepo;
import com.example.LibraryMgmt.repository.TakeBookRepo;
import com.example.LibraryMgmt.service.TakeBookService;
import static java.util.Objects.nonNull;
import static com.example.LibraryMgmt.dtoMapper.TakeBookMapper.TO_TAKE_BOOKK;
import static com.example.LibraryMgmt.dtoMapper.TakeBookMapper.TO_TAKE_BOOK_LIST;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TakeBookServiceImpl implements TakeBookService {

	private final TakeBookRepo takeBookRepo;
	private final BookRepo bookRepo;

	@Override
	public Optional<TakeBookDto> borrowBookSave(TakeBook takeBook) throws Exception {

		Book book = bookRepo.findByBookId(takeBook.getBook().getBookId());
		if (nonNull(book)) {
			if (book.getStatus().equalsIgnoreCase("available")) {
				LocalDateTime now = LocalDateTime.now(); // Get the current date and time
				takeBook.setBorrowDate(now);
				takeBook.setReturnDate(now.plusDays(7));
				// to set the is return status of te book to Yes
				takeBook.setIsReturn("No");
				return TO_TAKE_BOOKK.apply(takeBookRepo.save(takeBook));
			} else
				throw new Exception("Book is not available to borrow");
		} else
			return Optional.empty();
	}

	@Override
	public List<TakeBookDto> getInfoOfBookForBorrowBook(Long takeBookId) {
		List<TakeBook> findByBookBookId = takeBookRepo.findAllByBookBookId(takeBookId);
		if (!findByBookBookId.isEmpty())
			return TO_TAKE_BOOK_LIST.apply(findByBookBookId);
		return Collections.emptyList();
	}

	@Override
	public Optional<TakeBookDto> updateTakeBookStatusOfIsReturn(Long bookId, Long membId) {
		Optional<TakeBook> takeBook = takeBookRepo.findByBookBookIdAndMemberMasterMembId(bookId, membId);
		if (takeBook.isPresent()) {
			takeBook.get().setIsReturn("Yes");
			return TO_TAKE_BOOKK.apply(takeBookRepo.save(takeBook.get()));
		}
		return Optional.empty();
	}

}
