package com.pefindo.score.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
public class users extends PanacheEntityBase{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String nama;
	public String username;
	public String password;
	public String role_code;
	public String ip_address;
	public Integer id_member;

	public static users findByNama(String nama){
		return find("nama", nama).firstResult();
	}
	public static users findById(Long id){
		return find("id", id).firstResult();
	}
}
