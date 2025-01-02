package com.example.LibraryMgmt.serviceImpl;

import static com.example.LibraryMgmt.dtoMapper.MemberMapper.TO_MEMBER;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.LibraryMgmt.dto.MemberDto;
import com.example.LibraryMgmt.entity.MemberMaster;
import com.example.LibraryMgmt.repository.MemberRepo;
import com.example.LibraryMgmt.service.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	private final MemberRepo memberRepo;

	@Override
	public Optional<MemberDto> addMember(MemberMaster member) {
		System.out.println("In save......");
		return TO_MEMBER.apply(memberRepo.save(member));
	}

}
