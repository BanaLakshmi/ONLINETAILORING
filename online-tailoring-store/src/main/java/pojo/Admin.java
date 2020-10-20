package pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AdminMaster")
public class Admin {
	@Id
	private int adminId;
	private String adminMaster;
	private String password;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminMaster() {
		return adminMaster;
	}
	public void setAdminMaster(String adminMaster) {
		this.adminMaster = adminMaster;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(int adminId, String adminMaster, String password) {
		super();
		this.adminId = adminId;
		this.adminMaster = adminMaster;
		this.password = password;
	}
	

}
