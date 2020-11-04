package com.example.demo;
import java.util.List;
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


	

}
