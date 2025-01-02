package com.example.LibraryMgmt.serviceImpl;

import static com.example.LibraryMgmt.dtoMapper.LibraryMapper.TO_LIBRARY;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.LibraryMgmt.dto.LibraryDto;
import com.example.LibraryMgmt.entity.Library;
import com.example.LibraryMgmt.repository.BookRepo;
import com.example.LibraryMgmt.repository.LibraryRepo;
import com.example.LibraryMgmt.service.LibraryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService{
	
	private final BookRepo bookRepo;
	private final LibraryRepo libraryRepo;

	@Override
	public Optional<LibraryDto> addLibrary(Library library) {
		System.out.println("In save......");
		return TO_LIBRARY.apply(libraryRepo.save(library));

	}

}
