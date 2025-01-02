package com.example.LibraryMgmt.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
	
	private Long bookId;

	private String bookName;

	private String status;

	private LocalDateTime issuedDate;

}
