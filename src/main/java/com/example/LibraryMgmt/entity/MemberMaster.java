package com.example.LibraryMgmt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="member")
@NamedQuery(name = "MemberMaster.findAll", query = "SELECT a FROM MemberMaster a")
public class MemberMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="memb_Id")
	private Long membId;
	
	@Column(name="memb_name" ,nullable = false)
	private String membName;
	
	@Column(name="memb_phone_no")
	private String membPhoneNo;
	
	@OneToOne(mappedBy = "memberMaster")
	private TakeBook takeBook;
	
}
