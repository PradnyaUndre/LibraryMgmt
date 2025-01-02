package com.example.LibraryMgmt.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryMgmt.dto.MemberDto;
import com.example.LibraryMgmt.service.MemberService;
import com.example.LibraryMgmt.util.MemberUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberApi {
	
	private final MemberService memberService;
	private final MemberUtil memberUtil;

	@PostMapping
	public Map<String, Object> saveMember(@RequestBody MemberDto memberDto) {
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("Success", true);
			map.put("DATA", memberService.addMember(memberUtil.toMember(memberDto)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	
}
