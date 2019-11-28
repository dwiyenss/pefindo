package com.pefindo.Model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class Members extends PanacheEntity{
	public String member_code;
	public String member_name;
	public String active_flag;
	public String image;

	public static Members findByMemberName(String member_name){
		return find("member_name", member_name).firstResult();
	}
	public static Members findById(Long id){
		return find("id", id).firstResult();
	}
}
