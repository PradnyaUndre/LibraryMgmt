package com.example.LibraryMgmt.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryMgmt.dto.BookDto;
import com.example.LibraryMgmt.service.BookService;
import com.example.LibraryMgmt.util.BookUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("book")
public class BookApi {

	private final BookService bookService;
	private final BookUtil bookUtil;

	@GetMapping("/getMessageConsole")
	public Map<String, String> getMessageConsole() {
		Map<String, String> map = new HashMap<>();
		System.out.println("In control 1 2 3....");
		map.put("DATA", "fsgdfsd");
		return map;
	}

	@PostMapping
	public Map<String, Object> addBook(@RequestBody BookDto bookDto) {
		Map<String, Object> map = new HashMap<>();
		try {
			System.out.println("In save.......");
			map.put("DATA", bookService.addBook(bookUtil.toBook(bookDto))
					.orElseThrow(() -> new Exception("Unable to save book details.... ")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@PostMapping("/returnbook/book/{bookId}/member/{membId}")
	public Map<String, Object> returnBook(@PathVariable("bookId") Long bookId, @PathVariable("membId") Long membId) {
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("Success", true);
			map.put("DATA", bookService.returnBook(bookId, membId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@GetMapping("/getallavailablebooks")
	public Map<String, Object> getInfoOfAvailableBookInfo() {
		Map<String, Object> map = new HashMap<>();
		try {
			map.put("DATA", bookService.getInfoOfAvailableBookInfo());
			map.put("Success", true);
		} catch (Exception e) {
			log.error("Error occurred while getting info of available books.: ", e);
			// Return a general error message in the response
			map.put("ERROR", "An unexpected error occurred while getting info of available books.");
			return map;
		}
		return map;
	}

}
