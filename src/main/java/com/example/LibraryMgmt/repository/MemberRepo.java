package com.example.LibraryMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryMgmt.entity.MemberMaster;

@Repository
public interface MemberRepo extends JpaRepository<MemberMaster, Long> {
	
	Boolean existsByMembId(Long membId);

}
