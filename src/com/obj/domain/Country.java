package com.obj.domain;

/**
 * Clase de entidad Country
 * @author Jrsaavedra
 *
 */
public class Country {
	// Atributos
	private Integer id;
    private String country;
    
    // Métodos getter and setter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
    
}
