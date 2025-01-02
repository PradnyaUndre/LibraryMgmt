package com.example.LibraryMgmt.dtoMapper;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.example.LibraryMgmt.dto.BookDto;
import com.example.LibraryMgmt.entity.Book;

public class BookMapper {

	private static final ModelMapper modelMapper = new ModelMapper();

	private BookMapper() {
	}

	// Function to map DesignationDto to DesignationMaster
	public static final Function<BookDto, Optional<Book>> TO_BOOK_MASTER = dto -> Optional.ofNullable(dto)
			.map(d -> modelMapper.map(d, Book.class));

	// Function to map DesignationMaster to DesignationDto using ModelMapper
	public static final Function<Book, Optional<BookDto>> TO_BOOK = e -> Optional.ofNullable(e)
			.map(entity -> modelMapper.map(entity, BookDto.class));

	public static final Function<List<Book>, List<BookDto>> TO_BOOK_LIST = e -> e.stream()
			.map(TO_BOOK) // Apply TO_TAKE_BOOKK function to each entity
			.filter(Optional::isPresent) // Filter out empty Optionals
			.map(Optional::get) // Extract the value from each Optional
			.collect(Collectors.toList()); // Collect the results into a List
}
