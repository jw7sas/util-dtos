package com.obj.dto;

public class ConfDtoDTO {
	
	// Atributos
    private Integer id;
    private String dtoName;
    private String dtoClasName;
    private String dtoField;
    private Boolean dtoIsRequired;
    private Boolean dtoIsObject;
    private String dtoDatatype;
    private String entityField;
    private Boolean isMapper;
    
    // Métodos getter and setter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDtoName() {
		return dtoName;
	}
	public void setDtoName(String dtoName) {
		this.dtoName = dtoName;
	}
	public String getDtoClasName() {
		return dtoClasName;
	}
	public void setDtoClasName(String dtoClasName) {
		this.dtoClasName = dtoClasName;
	}
	public String getDtoField() {
		return dtoField;
	}
	public void setDtoField(String dtoField) {
		this.dtoField = dtoField;
	}
	public Boolean getDtoIsRequired() {
		return dtoIsRequired;
	}
	public void setDtoIsRequired(Boolean dtoIsRequired) {
		this.dtoIsRequired = dtoIsRequired;
	}
	public Boolean getDtoIsObject() {
		return dtoIsObject;
	}
	public void setDtoIsObject(Boolean dtoIsObject) {
		this.dtoIsObject = dtoIsObject;
	}
	public String getDtoDatatype() {
		return dtoDatatype;
	}
	public void setDtoDatatype(String dtoDatatype) {
		this.dtoDatatype = dtoDatatype;
	}
	public String getEntityField() {
		return entityField;
	}
	public void setEntityField(String entityField) {
		this.entityField = entityField;
	}
	public Boolean getIsMapper() {
		return isMapper;
	}
	public void setIsMapper(Boolean isMapper) {
		this.isMapper = isMapper;
	}
}
