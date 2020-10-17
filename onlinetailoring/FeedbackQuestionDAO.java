

import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;   

@SuppressWarnings("hiding")
public class FeedbackQuestionDAO<HibernateTemplate> {

	HibernateTemplate ht;  


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	public void saveFeedbackQuestion(FeedbackQuestion  feedbackQuestion){  
		((org.springframework.orm.hibernate5.HibernateTemplate) ht).save(feedbackQuestion);  
	}  
	public void updateFeedbackQuestion(FeedbackQuestion feedbackQuestion){  
		((org.springframework.orm.hibernate5.HibernateTemplate) ht).update(feedbackQuestion);  
	}  
	public void deleteFeedbackQuestion(FeedbackQuestion feedbackQuestion){  
		((org.springframework.orm.hibernate5.HibernateTemplate) ht).delete(feedbackQuestion);  
	}  
	public FeedbackQuestion getById(int id){  
		FeedbackQuestion feedbackQuestion=(FeedbackQuestion)((org.springframework.orm.hibernate5.HibernateTemplate) ht).get(FeedbackQuestion.class,id);  
		return feedbackQuestion ;
	}  
	public List<FeedbackQuestion> getFeedbackQuestion(){  
		List<FeedbackQuestion> list=new ArrayList<FeedbackQuestion>();  
		list=((org.springframework.orm.hibernate5.HibernateTemplate) ht).loadAll(FeedbackQuestion.class);  
		return list;  
	}  
}
