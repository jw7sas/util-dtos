package com.obj.dto;

/**
 * Clase EditorialDTO
 * @author Jrsaavedra
 *
 */
public class EditorialDTO {
	// Atributos
	private int id;
    private String editorial;
    private int countryId;
    private CountryDTO country;
	
    // Métodos getter and setter
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
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
