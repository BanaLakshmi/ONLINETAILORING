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
	public SecretQuestions  read (String userId,String a1,String a2,String a3)
	{
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT q From  SecretQuestions q WHERE q.userId=? AND q.a1=? AND q.a2=? AND q.a3=?");
		query.setParameter(0, userId);
		query.setParameter(1, a1);
		query.setParameter(2, a2);
		query.setParameter(3, a3);
		List<SecretQuestions>  s = query.list();
		if(s==null || s.size()==0) {
			return null;
		}
	return s.get(0);
	}
	public SecretQuestions  readUserId (String email,String a1,String a2,String a3)
	{
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT q From  SecretQuestions q WHERE q.email=? AND q.a1=? AND q.a2=? AND q.a3=?");
		query.setParameter(0, email);
		query.setParameter(1, a1);
		query.setParameter(2, a2);
		query.setParameter(3, a3);
		List<SecretQuestions>  s = query.list();
		if(s==null || s.size()==0) {
			return null;
		}
	return s.get(0);
	}
}
