package com.pefindo.score.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
public class modelParameters extends PanacheEntityBase{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@Column(name = "parameter", nullable = false )
	public String parameter;
	
	@Column(name = "label", nullable = false )
	public String label;
	
	@Column(name = "tipe_data", nullable = false )
	public String tipeData;
	
	@Column(name = "is_web", nullable = false )
	public String isWeb;
	
	@Column(name = "id_model", nullable = false )
	public String idModel;

	public static modelParameters findByLabel(String label){
		return find("label", label).firstResult();
	}
	public static modelParameters findById(Long id){
		return find("id", id).firstResult();
	}
}
