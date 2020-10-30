package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tailor_Dress")
public class TailorDress {
	@Id
	private int tailorDressId; 
	private String tailorId; 
	private int categoryId; 
	private String dressType;
	private String dressKind;
	private byte[] pattern;
	private double cost;
	public TailorDress(int tailorDressId, String tailorId, int categoryId, String dressType, String dressKind,
			byte[] pattern, double cost) {
		super();
		this.tailorDressId = tailorDressId;
		this.tailorId = tailorId;
		this.categoryId = categoryId;
		this.dressType = dressType;
		this.dressKind = dressKind;
		this.pattern = pattern;
		this.cost = cost;
	}
	public TailorDress() {
		super();
	}
	public int getTailorDressId() {
		return tailorDressId;
	}
	public void setTailorDressId(int tailorDressId) {
		this.tailorDressId = tailorDressId;
	}
	public String getTailorId() {
		return tailorId;
	}
	public void setTailorId(String tailorId) {
		this.tailorId = tailorId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDressType() {
		return dressType;
	}
	public void setDressType(String dressType) {
		this.dressType = dressType;
	}
	public String getDressKind() {
		return dressKind;
	}
	public void setDressKind(String dressKind) {
		this.dressKind = dressKind;
	}
	public byte[] getPattern() {
		return pattern;
	}
	public void setPattern(byte[] pattern) {
		this.pattern = pattern;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	} 
	

}
