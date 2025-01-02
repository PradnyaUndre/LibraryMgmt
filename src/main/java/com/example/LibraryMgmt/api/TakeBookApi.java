package com.example.LibraryMgmt.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryMgmt.dto.TakeBookDto;
import com.example.LibraryMgmt.exception.RecordNotFoundException;
import com.example.LibraryMgmt.repository.BookRepo;
import com.example.LibraryMgmt.repository.MemberRepo;
import com.example.LibraryMgmt.service.MemberService;
import com.example.LibraryMgmt.service.TakeBookService;
import com.example.LibraryMgmt.util.TakeBookUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("takebook")
public class TakeBookApi {

	private final TakeBookService takeBookService;
	private final MemberService memberService;
	private final MemberRepo memberRepo;
	private final BookRepo bookRepo;
	private final TakeBookUtil takeBookUtil;

	@PostMapping
	public Map<String, Object> borrowBook(@RequestBody TakeBookDto takeBookDto) {
		Map<String, Object> map = new HashMap<>();
		try {
			System.out.println("aaaa"+memberRepo.existsByMembId(takeBookDto.getMemberDto().getMembId()));
			if(Boolean.FALSE.equals(memberRepo.existsByMembId(takeBookDto.getMemberDto().getMembId())))
				throw new RecordNotFoundException("Member Record not found");
			if(Boolean.FALSE.equals(bookRepo.existsByBookId(takeBookDto.getBookDto().getBookId())))
				throw new RecordNotFoundException("Book Record not found");
			map.put("DATA", takeBookService.borrowBookSave(takeBookUtil.toTakeBook(takeBookDto))
					.orElseThrow(() -> new Exception("Unable to save borrow book record.... ")));
			map.put("Success", true);
		} catch (RecordNotFoundException e) {
	        // Handle RecordNotFoundException specifically
	        log.error("Record not found: ", e);
	        map.put("ERROR", e.getMessage());  // Return the specific error message for not found record
	        map.put("Success", false);
	    } catch (Exception e) {
			log.error("Error occurred while saving library: ", e);
			map.put("ERROR", "An unexpected error occurred while processing your request.");
			map.put("Success", false);
			return map;
		}
		return map;
	}
	
	@GetMapping("/book/{bookId}")
	public Map<String, Object> getInfoOfBookForBorrowBook(@PathVariable("bookId") Long bookId) {
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("DATA", takeBookService.getInfoOfBookForBorrowBook(bookId));
			map.put("Success", true);
		} catch (Exception e) {
			log.error("Error occurred while saving library: ", e);
			map.put("ERROR", "An unexpected error occurred while processing your request.");
			return map;
		}
		return map;
	}

}
