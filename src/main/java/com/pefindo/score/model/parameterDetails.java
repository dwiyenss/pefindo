package com.pefindo.score.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class parameterDetails extends PanacheEntityBase {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	public long id;
	public int sequence;
	public String operator;
	public float start_value;
	public String end_value;
	public String like_value;
	public float weight;
	public String reason_code;
	public int id_model_parameter;
	public int id_reason_code;
	
	public static parameterDetails findByName(String operators) {
		return find("operator", operators).firstResult();
	}
}
