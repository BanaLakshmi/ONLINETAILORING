package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("sQdao")
public class SecretQuestionsDAO {
	private static final String ScrollableResults = null;
	HibernateTemplate ht;  


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	//method to save SecretQuestions
	@Transactional
	public SecretQuestions saveSecretQuestions(SecretQuestions secretQuestions){  
		ht.save(secretQuestions);
		return secretQuestions;  
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
	public List<SecretQuestions> getSecretQuestionses(){  
		List<SecretQuestions> list=new ArrayList<SecretQuestions>();  
		list=ht.loadAll(SecretQuestions.class);  
		return list;  
	}  
//	public SecretQuestions  read (String userId,String a1,String a2,String a3)
//	{
//		Session session = ht.getSessionFactory().openSession();
//		Query query = session.createQuery("SELECT q From  SecretQuestions q WHERE q.userId=:userId AND q.a1=:a1 AND q.a2=:a3 AND q.a3=:a3");
//		query.setString(1, userId);
//		query.setString(2, a1);
//		query.setString(3, a2);
//		query.setString(4, a3);
//	
//		return query;
//	}
	
}
