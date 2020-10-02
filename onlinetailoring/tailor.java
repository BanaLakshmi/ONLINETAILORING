package com.mahidhar.project;

public class Tailor {
	private int tailorId;
	private String shopName;
	private String address;
	private String contactNo;
	private int workingHours;
	private boolean courier;

	public Tailor(int tailorId, String shopName, String address, String contactNo, int workingHours, boolean courier) {
		super();
		this.tailorId = tailorId;
		this.shopName = shopName;
		this.address = address;
		this.contactNo = contactNo;
		this.workingHours = workingHours;
		this.courier = courier;
	}

	public int getTailorId() {
		return tailorId;
	}

	public void setTailorId(int tailorId) {
		this.tailorId = tailorId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	public boolean isCourier() {
		return courier;
	}

	public void setCourier(boolean courier) {
		this.courier = courier;
	}

}
