package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class DressCategory {
	@Id
	@Column(name = "categoryId")
	private int categoryId;
	private String dressCategory;
	
    public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDressCategory() {
		return dressCategory;
	}
	public void setDressCategory(String dressCategory) {
		this.dressCategory = dressCategory;
	}
	
	public DressCategory(int categoryId, String dressCategory) {
		super();
		this.categoryId = categoryId;
		this.dressCategory = dressCategory;
	}
}
