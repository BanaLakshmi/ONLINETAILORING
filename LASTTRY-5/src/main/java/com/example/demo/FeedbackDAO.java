package com.example.demo;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("feedbackDao")
public class FeedbackDAO {
	
	HibernateTemplate ht; 


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	@Transactional
	public Feedback create(Feedback feeedback)
	{
		ht.save(feeedback);
		return feeedback;
	}
	
	@Transactional
	public void saveFeedback(Feedback  feedback){  
	                  ht.save(feedback);  
	} 
	@Transactional
	public void updateFeedback(Feedback feedback){  
		 ht.update(feedback);  
	}  
	@Transactional
	public void delete(Feedback feedback){  
		 ht.delete(feedback);  
	}  
	public Feedback getById(int feedbackId){  
		return ht.get(Feedback.class, feedbackId);
	}  
	public List<Feedback>  read(){
		return ht.loadAll(Feedback.class);
	} 

	public List<Feedback> getBytailorId (String tailorId)
	{
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT f From  Feedback f WHERE f.tailorId=?");
		query.setParameter(0, tailorId);
		List<Feedback> s = query.list();
		return s;
	}

}
