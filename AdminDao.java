package com.mfrp.onlinetailoring;
import java.util.List;
import java.util.ArrayList;


import org.springframework.orm.hibernate5.HibernateTemplate;


public class AdminDao {
	
	HibernateTemplate ht;  

public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}


	
	//method to save Admin
	public void saveAdmin(Admin admin){  
		ht.save(admin);  
	}  

//method to update Admin
	public void updateAdmin(Admin admin){  
		ht.update(admin);  
	} 
//method to delete Admin 
	public void deleteAdmin(Admin admin){  
		ht.delete(admin);  
	}   
//method to return  Admin of given adminId  
	public Admin getByAdminId(int adminId){  
		Admin admin=(Admin)ht.get(Admin.class,adminId);  
		return admin; 
}
} 


	

	
	
	
	
