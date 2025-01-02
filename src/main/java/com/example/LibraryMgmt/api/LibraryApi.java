package com.example.LibraryMgmt.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryMgmt.dto.LibraryDto;
import com.example.LibraryMgmt.service.LibraryService;
import com.example.LibraryMgmt.util.LibraryUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("library")
public class LibraryApi {

	private final LibraryService libraryService;
	private final LibraryUtil libraryUtil;

	@PostMapping
	public Map<String, Object> saveLibrary(@RequestBody LibraryDto libraryDto) {
		Map<String, Object> map = new HashMap<>();
		try {

			map.put("DATA", libraryService.addLibrary(libraryUtil.toLibrary(libraryDto)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
