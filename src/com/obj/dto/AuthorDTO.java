package com.obj.dto;

/**
 * Clase AuthorDTO
 * @author Jrsaavedra
 *
 */
public class AuthorDTO {
	// Atributos
	private int id;
    private String name;
    private int countryId;
    private CountryDTO country;
    
    // Métodos getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public CountryDTO getCountry() {
		return country;
	}
	public void setCountry(CountryDTO country) {
		this.country = country;
	}
}
