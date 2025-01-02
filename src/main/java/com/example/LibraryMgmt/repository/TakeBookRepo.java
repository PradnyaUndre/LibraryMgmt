package com.example.LibraryMgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryMgmt.entity.TakeBook;

@Repository
public interface TakeBookRepo extends JpaRepository<TakeBook, Long> {
	
	List<TakeBook> findAllByBookBookId(Long bookId);
	
	Optional<TakeBook> findByBookBookIdAndMemberMasterMembId(Long bookId, Long membId);

}
