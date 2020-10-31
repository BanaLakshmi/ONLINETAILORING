package com.example.demo;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(name="Tailor_Dress")
public class TailorDress {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tailorDressId; 
	private String tailorId; 
	private int categoryId; 
	private String dressType;
	private String dressKind;
	private byte[] pattern;
	private double cost;
	public TailorDress(String tailorId, int categoryId,  String dressKind,String dressType,
			byte[] pattern, double cost) {
		super();
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
	public String getPattern1()
	{
		return Base64.encodeBase64String(this.pattern);
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
	
	public String getPic1()
	{
		return Base64.encodeBase64String(this.pattern);
	}
	
	@Override
	public String toString() {
		return "TailorDress [tailorDressId=" + tailorDressId + ", tailorId=" + tailorId + ", categoryId=" + categoryId
				+ ", dressType=" + dressType + ", dressKind=" + dressKind + ", pattern=" + Arrays.toString(pattern)
				+ ", cost=" + cost + "]";
	}
	public TailorDress(int categoryId, String dressType, String dressKind) {
		super();
		this.categoryId = categoryId;
		this.dressType = dressType;
		this.dressKind = dressKind;
	} 
	
	

}
