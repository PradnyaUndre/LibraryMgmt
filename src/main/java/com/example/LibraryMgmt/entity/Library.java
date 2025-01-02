package com.example.LibraryMgmt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "Library")
@NamedQuery(name = "Library.findAll", query = "SELECT a FROM Library a")
public class Library {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="library_Id")
	private Long libraryId;
	
	@Column(name="name" ,nullable = false)
	private String name;
	
	@Column(name="address")
	private String address;

}
