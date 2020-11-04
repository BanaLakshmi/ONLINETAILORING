package com.example.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.query.Query;

@Entity
@Table(name="DressTypeMaster")
public class DressType {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dressTypeId;
	private String dressType ;
	private int categoryId;
	private String dressKind;
	
	public int getDressTypeId() {
		return dressTypeId;
	}
	public void setDressTypeId(int dressTypeId) {
		this.dressTypeId = dressTypeId;
	}
	public String getDressType() {
		return dressType;
	}
	public void setDressType(String dressType) {
		this.dressType = dressType;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	public String getDressKind() {
		return dressKind;
	}
	public void setDressKind(String dressKind) {
		this.dressKind = dressKind;
	}
	public DressType(int dressTypeId, String dressType, int categoryId, String dressKind) {
		super();
		this.dressTypeId = dressTypeId;
		this.dressType = dressType;
		this.categoryId = categoryId;
		this.dressKind = dressKind;
	}
	public DressType() {
		super();
	}
	
	
	
	
	
	
	
}
