package com.example.LibraryMgmt.util;

import static com.example.LibraryMgmt.dtoMapper.BookMapper.TO_BOOK_MASTER;
import static com.example.LibraryMgmt.dtoMapper.MemberMapper.TO_MEMBER_MASTER;
import static com.example.LibraryMgmt.dtoMapper.TakeBookMapper.TO_TAKE_BOOK_MASTER;
import static java.util.Objects.nonNull;

import org.springframework.stereotype.Component;

import com.example.LibraryMgmt.dto.TakeBookDto;
import com.example.LibraryMgmt.entity.Book;
import com.example.LibraryMgmt.entity.MemberMaster;
import com.example.LibraryMgmt.entity.TakeBook;
import com.example.LibraryMgmt.exception.DTOConvertionException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class TakeBookUtil {

	public TakeBook toTakeBook(TakeBookDto takeBookDto) throws Exception {
		TakeBook takeBook = TO_TAKE_BOOK_MASTER.apply(takeBookDto)
				.orElseThrow(() -> new DTOConvertionException("Unable to convert take book dto into take book entity."));
		if (nonNull(takeBookDto) && nonNull(takeBookDto.getBookDto())) {
			Book book = TO_BOOK_MASTER.apply(takeBookDto.getBookDto())
					.orElseThrow(() -> new DTOConvertionException("Unable to convert book dto into book master entity."));
			takeBook.setBook(book);
		}
		if (nonNull(takeBookDto) && nonNull(takeBookDto.getMemberDto())) {
			MemberMaster member = TO_MEMBER_MASTER.apply(takeBookDto.getMemberDto())
					.orElseThrow(() -> new DTOConvertionException("Unable to convert member dto into member master entity."));
			takeBook.setMemberMaster(member);
		}
		return takeBook;
	}

}
