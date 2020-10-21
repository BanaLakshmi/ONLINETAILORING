package com.example.demo;
import java.util.List;
import java.util.ArrayList;
import org.springframework.orm.hibernate5.HibernateTemplate;



public class UserDao {
	HibernateTemplate ht;  

public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
 //method to save User
	public void saveUser(User user){  
		ht.save(user);  
	}  

//method to update User
	public void updateUser(User user){  
		ht.update(user);  
	} 
//method to delete User 
	public void deleteUser(User user){  
		ht.delete(user);  
	}   
//method to return  User given the userId  
	public User getByUserId(int userId){  
		User user=(User)ht.get(User.class,userId);  
		return user; 
}
	//method to return all Users
	
	public List<User> getUsers(){  
		List<User> list=new ArrayList<>();  
		list=ht.loadAll(User.class);  
		return list;  
	}  

	

}
