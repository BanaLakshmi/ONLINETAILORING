package com.mahidhar.project;

public class TopMeasurement {
	private int topId;
	private String fabric;
	private String materialType;
	private int duration;
	private double topLength, amount, neck, topWaist, chest, shoulderLength;

	public TopMeasurement(int topId, String fabric, String materialType, int duration, double topLength, double amount,
			double neck, double topWaist, double chest, double shoulderLength) {
		super();
		this.topId = topId;
		this.fabric = fabric;
		this.materialType = materialType;
		this.duration = duration;
		this.topLength = topLength;
		this.amount = amount;
		this.neck = neck;
		this.topWaist = topWaist;
		this.chest = chest;
		this.shoulderLength = shoulderLength;
	}

	public int getTopId() {
		return topId;
	}

	public void setTopId(int topId) {
		this.topId = topId;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getTopLength() {
		return topLength;
	}

	public void setTopLength(double topLength) {
		this.topLength = topLength;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getNeck() {
		return neck;
	}

	public void setNeck(double neck) {
		this.neck = neck;
	}

	public double getTopWaist() {
		return topWaist;
	}

	public void setTopWaist(double topWaist) {
		this.topWaist = topWaist;
	}

	public double getChest() {
		return chest;
	}

	public void setChest(double chest) {
		this.chest = chest;
	}

	public double getShoulderLength() {
		return shoulderLength;
	}

	public void setShoulderLength(double shoulderLength) {
		this.shoulderLength = shoulderLength;
	}

}
