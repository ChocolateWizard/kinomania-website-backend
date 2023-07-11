/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.borak.kinweb.backend.domain.jpa.classes;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Mr Poyo
 */
@Entity(name = "Country")
@Table(name = "country")
@Access(AccessType.FIELD)
public class CountryJPA implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "official_state_name")
    private String officialStateName;

    @Column(name = "code")
    private String code;

    public CountryJPA() {
    }

    public CountryJPA(String name, String officialStateName, String code) {
        this.name = name;
        this.officialStateName = officialStateName;
        this.code = code;
    }   
    

    public CountryJPA(Long id, String name, String officialStateName, String code) {
        this.id = id;
        this.name = name;
        this.officialStateName = officialStateName;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficialStateName() {
        return officialStateName;
    }

    public void setOfficialStateName(String officialStateName) {
        this.officialStateName = officialStateName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return name + " (" + code + ')';
    }

    
    

}
