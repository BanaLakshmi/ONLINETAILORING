package com.example.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	private String customerId;
	private int tailorDressId;
	private String fabric;
	private String materialType;
	private Double topLengths;
	private Double neck;
	private Double topwaist;
	private Double chest;
	private Double shoulderLength;
	private String bottomFabric;
	private String bottomMaterialType;
	private Double bottomLengths;
	private Double hip;
	private Double kneeLength;
	private String comments;
	private Date expectedDate;
	private String deliveryArea;
	private String tailorId;
	
	
	
	
	

		public Integer getOrderId() {
		return orderId;
	}






	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}






	public String getCustomerId() {
		return customerId;
	}






	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}






	public int getTailorDressId() {
		return tailorDressId;
	}






	public void setTailorDressId(int tailorDressId) {
		this.tailorDressId = tailorDressId;
	}






	public String getFabric() {
		return fabric;
	}






	public void setFabric(String fabric) {
		this.fabric = fabric;
	}






	public String getMaterialType() {
		return materialType;
	}






	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}






	public Double getTopLengths() {
		return topLengths;
	}






	public void setTopLengths(Double topLengths) {
		this.topLengths = topLengths;
	}






	public Double getNeck() {
		return neck;
	}






	public void setNeck(Double neck) {
		this.neck = neck;
	}






	public Double getTopwaist() {
		return topwaist;
	}






	public void setTopwaist(Double topwaist) {
		this.topwaist = topwaist;
	}






	public Double getChest() {
		return chest;
	}






	public void setChest(Double chest) {
		this.chest = chest;
	}






	public Double getShoulderLength() {
		return shoulderLength;
	}






	public void setShoulderLength(Double shoulderLength) {
		this.shoulderLength = shoulderLength;
	}






	public String getBottomFabric() {
		return bottomFabric;
	}






	public void setBottomFabric(String bottomFabric) {
		this.bottomFabric = bottomFabric;
	}






	public String getBottomMaterialType() {
		return bottomMaterialType;
	}






	public void setBottomMaterialType(String bottomMaterialType) {
		this.bottomMaterialType = bottomMaterialType;
	}






	public Double getBottomLengths() {
		return bottomLengths;
	}






	public void setBottomLengths(Double bottomLengths) {
		this.bottomLengths = bottomLengths;
	}






	public Double getHip() {
		return hip;
	}






	public void setHip(Double hip) {
		this.hip = hip;
	}






	public Double getKneeLength() {
		return kneeLength;
	}






	public void setKneeLength(Double kneeLength) {
		this.kneeLength = kneeLength;
	}






	public String getComments() {
		return comments;
	}






	public void setComments(String comments) {
		this.comments = comments;
	}






	public Date getExpectedDate() {
		return expectedDate;
	}






	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}






	public String getDeliveryArea() {
		return deliveryArea;
	}






	public void setDeliveryArea(String deliveryArea) {
		this.deliveryArea = deliveryArea;
	}






	public String getTailorId() {
		return tailorId;
	}






	public void setTailorId(String tailorId) {
		this.tailorId = tailorId;
	}






		public Order() {
		super();
	}

}
