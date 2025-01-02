package com.example.LibraryMgmt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name ="take_book")
@NamedQuery(name = "TakeBook.findAll", query = "SELECT a FROM TakeBook a")
public class TakeBook{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="take_book_id")
	private Long takeBookId;
	
	@Column(name="borrow_date")
	private LocalDateTime borrowDate;
	
	@Column(name="return_date")
	private LocalDateTime returnDate;
	
	@Column(name="is_return")
	private String isReturn;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="book_Id")
	private Book book;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="memb_Id")
	private MemberMaster memberMaster;
	

}
