package Dao.dao;



import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;

import pojo.FeedbackQuestion;   

public class FeedbackQuestionDAO {

	HibernateTemplate ht;  
	
	

	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	public void saveFeedbackQuestion(FeedbackQuestion  feedbackQuestion){  
		 ht.save(feedbackQuestion);  
	}  
	public void updateFeedbackQuestion(FeedbackQuestion feedbackQuestion){  
		 ht.update(feedbackQuestion);  
	}  
	public void deleteFeedbackQuestion(FeedbackQuestion feedbackQuestion){  
		 ht.delete(feedbackQuestion);  
	}  
	public FeedbackQuestion getById(int id){  
		FeedbackQuestion feedbackQuestion=(FeedbackQuestion) ht.get(FeedbackQuestion.class,id);  
		return feedbackQuestion ;
	}  
	public List<FeedbackQuestion> getFeedbackQuestion(){  
		List<FeedbackQuestion> list=new ArrayList<FeedbackQuestion>();  
		list=ht.loadAll(FeedbackQuestion.class);  
		return list;  
	}  
}
