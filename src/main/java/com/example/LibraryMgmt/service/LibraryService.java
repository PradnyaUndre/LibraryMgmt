package com.example.LibraryMgmt.service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.example.LibraryMgmt.dto.LibraryDto;
import com.example.LibraryMgmt.entity.Library;

@Transactional(readOnly=false)
public interface LibraryService {

	Optional<LibraryDto> addLibrary(Library library);

}
