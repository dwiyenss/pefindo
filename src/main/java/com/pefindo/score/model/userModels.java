package com.pefindo.score.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name= "user_model")
public class userModels extends PanacheEntityBase {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	public long id;

	@Column(name = "id_model", nullable = false )
	public int idModel;

	@Column(name = "id_user", nullable = false )
	public int idUser;

	@Column(name = "active_flag", nullable = false )
	public String activeFlag;
	
	public static userModels findByName(String active_flags) {
		// TODO Auto-generated method stub
		return find("activeFlag", active_flags).firstResult();
	}
	
	
    
}
