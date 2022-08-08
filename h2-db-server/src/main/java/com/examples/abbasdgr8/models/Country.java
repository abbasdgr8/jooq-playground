package com.examples.abbasdgr8.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Abbas Attarwala <abbas@muon-c.com>
 */
@Entity
public class Country {

    @Id
    @GeneratedValue
    private Long id;
    
    private String country_name;

    public Country() {
        super();
    }

    public Country(Long id, String country_name) {
        this.id = id;
        this.country_name = country_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", country_name=" + country_name + '}';
    }
}