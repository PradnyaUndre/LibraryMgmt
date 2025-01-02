package com.example.LibraryMgmt.dtoMapper;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.example.LibraryMgmt.dto.TakeBookDto;
import com.example.LibraryMgmt.entity.TakeBook;
import static com.example.LibraryMgmt.dtoMapper.BookMapper.TO_BOOK;
import static com.example.LibraryMgmt.dtoMapper.MemberMapper.TO_MEMBER;

public class TakeBookMapper {

	private static final ModelMapper modelMapper = new ModelMapper();

	private TakeBookMapper() {
	}

	// Function to map DesignationDto to DesignationMaster
	public static final Function<TakeBookDto, Optional<TakeBook>> TO_TAKE_BOOK_MASTER = dto -> Optional.ofNullable(dto)
			.map(d -> modelMapper.map(d, TakeBook.class));

	// Function to map DesignationMaster to DesignationDto using ModelMapper
	public static final Function<TakeBook, Optional<TakeBookDto>> TO_TAKE_BOOK = e -> Optional.ofNullable(e)
			.map(entity -> modelMapper.map(entity, TakeBookDto.class));

	public static final Function<TakeBook, Optional<TakeBookDto>> TO_TAKE_BOOKK = e -> {
		TakeBookDto takeBookDto = modelMapper.map(e, TakeBookDto.class);
		// If takeBookDto is not null, map the Book entity to BookDto and set it
		System.out.println("in mapper....");
		System.out.println("in mapper...." + takeBookDto.getTakeBookId());
		if (nonNull(takeBookDto)) {
			if (nonNull(e.getBook())) {
				System.out.println("book mapper");
				TO_BOOK.apply(e.getBook()).ifPresent(takeBookDto::setBookDto);
			}
			if (nonNull(e.getMemberMaster())) {
				System.out.println("member mapper");
				TO_MEMBER.apply(e.getMemberMaster()).ifPresent(takeBookDto::setMemberDto);
			}

			return Optional.of(takeBookDto);
		}
		return Optional.empty();
	};

	public static final Function<List<TakeBook>, List<TakeBookDto>> TO_TAKE_BOOK_LIST = e -> e.stream()
			.map(TO_TAKE_BOOKK) // Apply TO_TAKE_BOOKK function to each entity
			.filter(Optional::isPresent) // Filter out empty Optionals
			.map(Optional::get) // Extract the value from each Optional
			.collect(Collectors.toList()); // Collect the results into a List

}
