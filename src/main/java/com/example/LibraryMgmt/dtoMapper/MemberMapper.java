package com.example.LibraryMgmt.dtoMapper;

import java.util.Optional;
import java.util.function.Function;

import org.modelmapper.ModelMapper;

import com.example.LibraryMgmt.dto.MemberDto;
import com.example.LibraryMgmt.entity.MemberMaster;

public class MemberMapper {

	private static final ModelMapper modelMapper = new ModelMapper();

	private MemberMapper() {
	}

	// Function to map DesignationDto to DesignationMaster
	public static final Function<MemberDto, Optional<MemberMaster>> TO_MEMBER_MASTER = dto -> Optional.ofNullable(dto)
			.map(d -> modelMapper.map(d, MemberMaster.class));

	// Function to map DesignationMaster to DesignationDto using ModelMapper
	public static final Function<MemberMaster, Optional<MemberDto>> TO_MEMBER = e -> Optional.ofNullable(e)
			.map(entity -> modelMapper.map(entity, MemberDto.class));

}
