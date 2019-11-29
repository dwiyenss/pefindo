package com.pefindo.score.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class userModels extends PanacheEntityBase {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	public long id;
	public int id_model;
	public int id_user;
	public String active_flag;
	
	public static userModels findByName(String active_flags) {
		// TODO Auto-generated method stub
		return find("active_flag", active_flags).firstResult();
	}
	
	
    
}
