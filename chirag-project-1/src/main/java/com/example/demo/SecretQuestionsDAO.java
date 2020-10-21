package com.example.demo;


import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



@Component("sQdao")
public class SecretQuestionsDAO {
	HibernateTemplate ht;  


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	//method to save SecretQuestions
	@Transactional
	public void saveSecretQuestions(SecretQuestions secretQuestions){  
		ht.save(secretQuestions);  
	}  
	@Transactional
	public void create(SecretQuestions secretQuestions)
	{
		ht.save(secretQuestions);
	}
	//method to update SecretQuestions
	@Transactional
	public void updateSecretQuestions(SecretQuestions secretQuestions){  
		ht.update(secretQuestions);  
	}  
	//method to delete SecretQuestions  
	@Transactional
	public void deleteSecretQuestions(SecretQuestions secretQuestions){  
		ht.delete(secretQuestions);  
	}  
	//method to return one SecretQuestions of given id  
	public SecretQuestions getById(int id){  
		SecretQuestions secretQuestions=(SecretQuestions)ht.get(SecretQuestions.class,id);  
		return secretQuestions;  
	}  
	//method to return all employees  
	public List<SecretQuestions> read(){  
		return ht.loadAll(SecretQuestions.class) ;  
	}  
	

}
