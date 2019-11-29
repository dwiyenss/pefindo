package com.pefindo.score.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class parameterDetails extends PanacheEntityBase {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	public long id;

	@Column(name = "sequence", nullable = false )
	public int sequence;

	@Column(name = "operator", nullable = false )
	public String operator;

	@Column(name = "start_value", nullable = false )
	public float startValue;

	@Column(name = "end_value", nullable = false )
	public String endValue;

	@Column(name = "like_value", nullable = false )
	public String likeValue;

	@Column(name = "weight", nullable = false )
	public float weight;

	@Column(name = "reason_code", nullable = false )
	public String reasonCode;

	@Column(name = "id_model_parameter", nullable = false )
	public int idModelParameter;

	@Column(name = "id_reason_code", nullable = false )
	public int idReasonCode;
	
	public static parameterDetails findByName(String operators) {
		return find("operator", operators).firstResult();
	}
}
