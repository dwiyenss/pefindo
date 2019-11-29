package com.pefindo.score.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * reasons
 */
@Entity
@Table(name = "reasons")
public class reasons extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    
    @Column(name = "code", nullable = false)
    public String code;

    @Column(name = "description", nullable = false)
    public String description;
}