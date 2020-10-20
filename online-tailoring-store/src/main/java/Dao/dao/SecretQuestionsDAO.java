package Dao.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;

import pojo.SecretQuestions;  

public class SecretQuestionsDAO {
	HibernateTemplate ht;  


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	//method to save SecretQuestions
	public void saveSecretQuestions(SecretQuestions secretQuestions){  
		ht.save(secretQuestions);  
	}  
	//method to update SecretQuestions
	public void updateSecretQuestions(SecretQuestions secretQuestions){  
		ht.update(secretQuestions);  
	}  
	//method to delete SecretQuestions  
	public void deleteSecretQuestions(SecretQuestions secretQuestions){  
		ht.delete(secretQuestions);  
	}  
	//method to return one SecretQuestions of given id  
	public SecretQuestions getById(int id){  
		SecretQuestions secretQuestions=(SecretQuestions)ht.get(SecretQuestions.class,id);  
		return secretQuestions;  
	}  
	//method to return all employees  
	public List<SecretQuestions> getSecretQuestionses(){  
		List<SecretQuestions> list=new ArrayList<SecretQuestions>();  
		list=ht.loadAll(SecretQuestions.class);  
		return list;  
	}  
	

}
