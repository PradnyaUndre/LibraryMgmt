package com.example.LibraryMgmt.util;

import static com.example.LibraryMgmt.dtoMapper.MemberMapper.TO_MEMBER_MASTER;

import org.springframework.stereotype.Component;

import com.example.LibraryMgmt.dto.MemberDto;
import com.example.LibraryMgmt.entity.MemberMaster;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MemberUtil {
	
	public MemberMaster toMember(MemberDto memberDto) throws Exception {
		MemberMaster member = TO_MEMBER_MASTER.apply(memberDto).orElseThrow(() -> new Exception("Unabe to convert member dto to entity"));
		return member;
	}

}
