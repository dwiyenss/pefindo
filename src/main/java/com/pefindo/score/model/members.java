package com.pefindo.score.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class members extends PanacheEntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String member_code;
	public String member_name;
	public String active_flag;
	public String image;

	public static members findByMemberName(String member_name){
		return find("member_name", member_name).firstResult();
	}
	public static members findById(Long id){
		return find("id", id).firstResult();
	}
}
