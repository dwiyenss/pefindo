package com.pefindo.score.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name= "members")
public class members extends PanacheEntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(name = "member_code", nullable = false )
	public String memberCode;
	
	@Column(name = "member_name", nullable = false )
	public String memberName;

	@Column(name = "active_flag", nullable = false )
	public String activeFlag;

	@Column(name = "image", nullable = false )
	public String image;

	public static members findByMemberName(String member_name){
		return find("memberName", member_name).firstResult();
	}
	public static members findById(Long id){
		return find("id", id).firstResult();
	}
}
