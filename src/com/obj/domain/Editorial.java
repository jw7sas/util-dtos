package com.obj.domain;

/**
 * Clase de entidad Editorial
 * @author Jrsaavedra
 *
 */
public class Editorial {
	//Atributos
	private Integer id;
    private String name;
    private Integer countryId;
    private Country country;
    
    // Métodos getter and setter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
}
