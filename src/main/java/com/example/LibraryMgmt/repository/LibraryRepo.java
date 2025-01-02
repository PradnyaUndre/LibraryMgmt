package com.example.LibraryMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryMgmt.entity.Library;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long>{

}
