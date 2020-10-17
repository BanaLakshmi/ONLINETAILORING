import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;   

@SuppressWarnings("hiding")
public class FeedbackDAO<HibernateTemplate> {
	HibernateTemplate ht;  


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	public void saveFeedbac(Feedback  feedback){  
		((org.springframework.orm.hibernate5.HibernateTemplate) ht).save(feedback);  
	}  
	public void updateFeedback(Feedback feedback){  
		((org.springframework.orm.hibernate5.HibernateTemplate) ht).update(feedback);  
	}  
	public void delete(Feedback feedback){  
		((org.springframework.orm.hibernate5.HibernateTemplate) ht).delete(feedback);  
	}  
	public Feedback getById(int id){  
		Feedback feedback=(Feedback)((org.springframework.orm.hibernate5.HibernateTemplate) ht).get(Feedback.class,id);  
		return feedback ;
	}  
	public List<Feedback> getFeedback(){  
		List<Feedback> list=new ArrayList<Feedback>();  
		list=((org.springframework.orm.hibernate5.HibernateTemplate) ht).loadAll(Feedback.class);  
		return list;  
	}  

}
