package com.pefindo.latihan;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class todo extends PanacheEntity{
	public String title;
	public boolean completed;
	@Column(name="ordering")
	public int order;

	public static todo findByTitle(String title){
		return find("title", title).firstResult();
	}
	public static todo findById(Long id){
		return find("id", id).firstResult();
	}
}
