package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "DressCategoryMaster")
public class DressCategory {
	@Id
	@Column(name = "categoryId")
	private int categoryId;
	private String category;
	
    public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDressCategory() {
		return category;
	}
	public void setDressCategory(String dressCategory) {
		this.category = dressCategory;
	}
	
	public DressCategory(int categoryId, String dressCategory) {
		super();
		this.categoryId = categoryId;
		this.category = dressCategory;
	}
}
