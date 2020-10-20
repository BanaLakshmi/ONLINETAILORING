package pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Help {
	@Id
	private int requestId ;
	private String issue ;
	private String description ;
	 private Date dateOfTicket ;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateOfTicket() {
		return dateOfTicket;
	}
	public void setDateOfTicket(Date dateOfTicket) {
		this.dateOfTicket = dateOfTicket;
	}
	public Help(int requestId, String issue, String description, Date dateOfTicket) {
		super();
		this.requestId = requestId;
		this.issue = issue;
		this.description = description;
		this.dateOfTicket = dateOfTicket;
	}

}
