package com.mfrp.onlinetailoring;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate5.HibernateTemplate;



public class HelpDao {
	
	HibernateTemplate ht;  

public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}


	
	//method to save Help
	public void saveHelp(Help help){  
		ht.save(help);  
	}  

//method to update Help
	public void updateHelp(Help help){  
		ht.update(admin);  
	} 
//method to delete Help
	public void deleteHelp(Help help){  
		ht.delete(help);  
	}   
//method to return Help of given requestId 
	public Help getByAdminId(int requestId){  
		Help help=(Help)ht.get(Help.class,requestId);  
		return help; 
}
} 


	

	
	
	
	

