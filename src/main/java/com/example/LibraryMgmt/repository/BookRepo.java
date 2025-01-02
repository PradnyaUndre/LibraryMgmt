package com.example.LibraryMgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryMgmt.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{
	
	Boolean existsByBookId(Long bookId);
	
	Book findByBookId(Long bookId);
	
	List<Book> findAllByStatus(String status);

}
