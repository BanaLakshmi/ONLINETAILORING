package pojo;




import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orders")

public class Orders {
	@Id @GeneratedValue

	private int orderId;
	private Date orderDate;
	private float billAmount;
	private Date acceptedDate;
	private Date expectedDelivery;
	private String status;
	private String paymentOption;
	private String typeofDelivery;
	private String paymentStatus;
	private Date actualDelivery;
	

	
	
	

	public int getOrderId() {
		return orderId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public float getBillAmount() {
		return billAmount;
	}



	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}



	public Date getAcceptedDate() {
		return acceptedDate;
	}



	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}



	public Date getExpectedDelivery() {
		return expectedDelivery;
	}



	public void setExpectedDelivery(Date expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getPaymentOption() {
		return paymentOption;
	}



	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}



	public String getTypeofDelivery() {
		return typeofDelivery;
	}



	public void setTypeofDelivery(String typeofDelivery) {
		this.typeofDelivery = typeofDelivery;
	}



	public String getPaymentStatus() {
		return paymentStatus;
	}



	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}



	public Date getActualDelivery() {
		return actualDelivery;
	}



	public void setActualDelivery(Date actualDelivery) {
		this.actualDelivery = actualDelivery;
	}
}
