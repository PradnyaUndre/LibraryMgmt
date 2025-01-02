package com.example.LibraryMgmt.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TakeBookDto {
	
	private Long takeBookId;

	private LocalDateTime borrowDate;

	private LocalDateTime returnDate;
	
	private String isReturn;

	private BookDto bookDto;

	private MemberDto memberDto;

}
