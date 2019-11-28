package com.pefindo.latihan;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
public class model_parameters extends PanacheEntity{
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
