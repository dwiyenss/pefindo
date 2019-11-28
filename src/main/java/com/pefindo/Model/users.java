package com.pefindo.Model;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class users extends PanacheEntity{
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
