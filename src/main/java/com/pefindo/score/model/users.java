package com.pefindo.score.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
@Table(name= "users")
public class users extends PanacheEntityBase{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(name = "nama", nullable = false )
	public String nama;

	@Column(name = "username", nullable = false )
	public String username;

	@Column(name = "password", nullable = false )
	public String password;

	@Column(name = "role_code", nullable = false )
	public String roleCode;

	@Column(name = "ip_address", nullable = false )
	public String ipAddress;

	@Column(name = "id_member", nullable = false )
	public Integer idMember;

	public static users findByNama(String nama){
		return find("nama", nama).firstResult();
	}
	public static users findById(Long id){
		return find("id", id).firstResult();
	}
}
