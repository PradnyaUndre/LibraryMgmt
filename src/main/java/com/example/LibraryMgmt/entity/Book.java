package com.example.LibraryMgmt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "book")
@NamedQuery(name = "Book.findAll", query = "SELECT a FROM Book a")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_Id")
	private Long bookId;

	@Column(name = "book_name" ,nullable = false)
	private String bookName;

	@Column(name = "status")
	private String status;

	@Column(name = "issued_date", nullable = true)
	private LocalDateTime issuedDate;
	
	@OneToOne(mappedBy = "book")
	private TakeBook takeBook;

//	@Version
//	@Column(name = "version")
//	private Long version; // Add this version field

}
