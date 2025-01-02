package com.example.LibraryMgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.example.LibraryMgmt.dto.TakeBookDto;
import com.example.LibraryMgmt.entity.TakeBook;

@Transactional(readOnly = false)
public interface TakeBookService {

	Optional<TakeBookDto> borrowBookSave(TakeBook takeBook) throws Exception;

	List<TakeBookDto> getInfoOfBookForBorrowBook(Long takeBookId);
	
	Optional<TakeBookDto> updateTakeBookStatusOfIsReturn(Long bookId, Long membId);

}
