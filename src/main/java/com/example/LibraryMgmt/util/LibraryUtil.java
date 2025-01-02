package com.example.LibraryMgmt.util;

import static com.example.LibraryMgmt.dtoMapper.LibraryMapper.TO_LIBRARY_MASTER;

import org.springframework.stereotype.Component;

import com.example.LibraryMgmt.dto.LibraryDto;
import com.example.LibraryMgmt.entity.Library;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class LibraryUtil {
	
	public Library toLibrary(LibraryDto libraryDto) throws Exception {
		Library book = TO_LIBRARY_MASTER.apply(libraryDto)
				.orElseThrow(() -> new Exception("Unable to convert library dto into library entity."));
		return book;

	}


}
