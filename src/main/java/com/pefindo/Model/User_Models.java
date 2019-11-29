package com.pefindo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class User_Models extends PanacheEntityBase {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	public long id;
	public int id_model;
	public int id_user;
	public String active_flag;
	
	public static User_Models findByName(String active_flags) {
		// TODO Auto-generated method stub
		return find("active_flag", active_flags).firstResult();
	}
	
	
    
}
