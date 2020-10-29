package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Feedback")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int orderId;
 private String dressType;
 private String fabric;
 private String materialType;
 private String duration;
 private String Toplengths;
 private String amout;
 private String neck;
 private String topwaist;
 private String chest;
private String shoulderLength;
 private String bottomFabric;
 private String bottomMaterialType;
 private String bottomDuration;
 private String bottomlengths;
 private String bottomamout;
 private String hip;
 private String Kneelength;
 private String comments;
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public String getDressType() {
	return dressType;
}
public void setDressType(String dressType) {
	this.dressType = dressType;
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
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public String getToplengths() {
	return Toplengths;
}
public void setToplengths(String toplengths) {
	Toplengths = toplengths;
}
public String getAmout() {
	return amout;
}
public void setAmout(String amout) {
	this.amout = amout;
}
public String getNeck() {
	return neck;
}
public void setNeck(String neck) {
	this.neck = neck;
}
public String getTopwaist() {
	return topwaist;
}
public void setTopwaist(String topwaist) {
	this.topwaist = topwaist;
}
public String getChest() {
	return chest;
}
public void setChest(String chest) {
	this.chest = chest;
}
public String getShoulderLength() {
	return shoulderLength;
}
public void setShoulderLength(String shoulderLength) {
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
public String getBottomDuration() {
	return bottomDuration;
}
public void setBottomDuration(String bottomDuration) {
	this.bottomDuration = bottomDuration;
}
public String getBottomlengths() {
	return bottomlengths;
}
public void setBottomlengths(String bottomlengths) {
	this.bottomlengths = bottomlengths;
}
public String getBottomamout() {
	return bottomamout;
}
public void setBottomamout(String bottomamout) {
	this.bottomamout = bottomamout;
}
public String getHip() {
	return hip;
}
public void setHip(String hip) {
	this.hip = hip;
}
public String getKneelength() {
	return Kneelength;
}
public void setKneelength(String kneelength) {
	Kneelength = kneelength;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
@Override
public String toString() {
	return "Order [orderId=" + orderId + ", dressType=" + dressType + ", fabric=" + fabric + ", materialType="
			+ materialType + ", duration=" + duration + ", Toplengths=" + Toplengths + ", amout=" + amout + ", neck="
			+ neck + ", topwaist=" + topwaist + ", chest=" + chest + ", shoulderLength=" + shoulderLength
			+ ", bottomFabric=" + bottomFabric + ", bottomMaterialType=" + bottomMaterialType + ", bottomDuration="
			+ bottomDuration + ", bottomlengths=" + bottomlengths + ", bottomamout=" + bottomamout + ", hip=" + hip
			+ ", Kneelength=" + Kneelength + ", comments=" + comments + "]";
}
public Order(int orderId, String dressType, String fabric, String materialType, String duration, String toplengths,
		String amout, String neck, String topwaist, String chest, String shoulderLength, String bottomFabric,
		String bottomMaterialType, String bottomDuration, String bottomlengths, String bottomamout, String hip,
		String kneelength, String comments) {
	super();
	this.orderId = orderId;
	this.dressType = dressType;
	this.fabric = fabric;
	this.materialType = materialType;
	this.duration = duration;
	Toplengths = toplengths;
	this.amout = amout;
	this.neck = neck;
	this.topwaist = topwaist;
	this.chest = chest;
	this.shoulderLength = shoulderLength;
	this.bottomFabric = bottomFabric;
	this.bottomMaterialType = bottomMaterialType;
	this.bottomDuration = bottomDuration;
	this.bottomlengths = bottomlengths;
	this.bottomamout = bottomamout;
	this.hip = hip;
	Kneelength = kneelength;
	this.comments = comments;
}
public Order() {
	super();
	// TODO Auto-generated constructor stub
}


}
