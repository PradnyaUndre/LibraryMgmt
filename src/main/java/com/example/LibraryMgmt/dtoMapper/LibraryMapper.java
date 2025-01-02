package com.example.LibraryMgmt.dtoMapper;

import java.util.Optional;
import java.util.function.Function;

import org.modelmapper.ModelMapper;

import com.example.LibraryMgmt.dto.LibraryDto;
import com.example.LibraryMgmt.entity.Library;

public class LibraryMapper {

	public static ModelMapper modelMapper = new ModelMapper();

	public static final Function<LibraryDto, Optional<Library>> TO_LIBRARY_MASTER = e -> Optional
			.ofNullable(modelMapper.map(e, Library.class));

	// Function to map DesignationMaster to DesignationDto using ModelMapper
	public static final Function<Library, Optional<LibraryDto>> TO_LIBRARY = e -> Optional.ofNullable(e)
			.map(entity -> modelMapper.map(entity, LibraryDto.class));
}
