package com.example.demo;

import java.util.Date;

import org.apache.tomcat.util.codec.binary.Base64;

public class GetOrderDetails {
	
	private int orderId;
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
	private String tailorId; 
	private int categoryId; 
	private String dressType;
	private String dressKind;
	private byte[] pattern;
	private double cost;
	private String deliveryArea;
	
	
	
	public String getDeliveryArea() {
		return deliveryArea;
	}
	public void setDeliveryArea(String deliveryArea) {
		this.deliveryArea = deliveryArea;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
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
	public String getPic1()
	{
		return Base64.encodeBase64String(this.pattern);
	}
	public GetOrderDetails() {
		super();
	}
	public GetOrderDetails(Order order,TailorDress tailorDress) {
		
		this.orderId = order.getOrderId();
		this.customerId = order.getCustomerId();
		this.tailorDressId = order.getTailorDressId();
		this.fabric = order.getFabric();
		this.materialType = order.getMaterialType();
		this.topLengths = order.getTopLengths();
		this.neck = order.getNeck();
		this.topwaist = order.getTopwaist();
		this.chest = order.getChest();
		this.shoulderLength = order.getShoulderLength();
		this.bottomFabric = order.getBottomFabric();
		this.bottomMaterialType = order.getBottomMaterialType();
		this.bottomLengths = order.getBottomLengths();
		this.hip = order.getHip();
		this.kneeLength = order.getKneeLength();
		this.comments = order.getComments();
		this.expectedDate = order.getExpectedDate();
		this.tailorId = tailorDress.getTailorId();
		this.categoryId = tailorDress.getCategoryId();
		this.dressType = tailorDress.getDressType();
		this.dressKind = tailorDress.getDressKind();
		this.pattern = tailorDress.getPattern();
		this.cost = tailorDress.getCost();
		this.deliveryArea = order.getDeliveryArea();
		
	}
	

	
	
	
	
}
