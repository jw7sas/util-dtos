package com.obj.dto;

import java.util.UUID;

/**
 * Clase BookDTO
 * @author Jrsaavedra
 *
 */
public class BookDTO {
	// Atributos
    private int id;
    private UUID code;
    private String title;
    private int authorId;
    private int editorialId;
    private String description;
    private int editionNumber;
    private int categoryId;
    private double price;
    private int stock;
    private boolean available;
    private String picture;
    private AuthorDTO author;
    private EditorialDTO editorial;
    private CategoryDTO category;
    
    
    public BookDTO () {}
    
    // Métodos getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UUID getCode() {
		return code;
	}
	public void setCode(UUID code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getEditorialId() {
		return editorialId;
	}
	public void setEditorialId(int editorialId) {
		this.editorialId = editorialId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEditionNumber() {
		return editionNumber;
	}
	public void setEditionNumber(int editionNumber) {
		this.editionNumber = editionNumber;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public EditorialDTO getEditorial() {
		return editorial;
	}

	public void setEditorial(EditorialDTO editorial) {
		this.editorial = editorial;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	@Override
	public String toString() {
		// Fields
		String obj = "   Id: " + this.id
				+ " \n 	Code: " + this.code.toString()
				+ " \n 	Title: " + this.title;
		return obj;
	}
}
