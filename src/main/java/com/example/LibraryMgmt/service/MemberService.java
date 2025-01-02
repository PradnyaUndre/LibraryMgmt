package com.example.LibraryMgmt.service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.example.LibraryMgmt.dto.MemberDto;
import com.example.LibraryMgmt.entity.MemberMaster;

@Transactional(readOnly = false)
public interface MemberService {

	Optional<MemberDto> addMember(MemberMaster member);

}
