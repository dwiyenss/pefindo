package com.pefindo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
public class model_parameters extends PanacheEntityBase{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;

	public String parameter;
	public String label;
	public String tipe_data;
	public String is_web;
	public String id_model;

	public static model_parameters findByLabel(String label){
		return find("label", label).firstResult();
	}
	public static model_parameters findById(Long id){
		return find("id", id).firstResult();
	}
}
