package com.pefindo.score.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * models
 */

 @Entity
 @Table(name = "models")
public class models extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nama", nullable = false)
    public String nama;

    @Column(name = "endpoint_tradisional", nullable = false)
    public String endpointTradisional;

    @Column(name = "endpoint_ai", nullable = false)
    public String endpointAi;

    @Column(name = "endpoint_bre", nullable = false)
    public String endpointBre;
    
    @Column(name = "base_score", nullable = false)
    public float baseScore;

    @Column(name = "icons", nullable = false)
    public String icons;

    
}