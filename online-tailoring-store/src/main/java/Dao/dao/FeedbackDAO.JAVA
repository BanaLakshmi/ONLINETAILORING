import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;   

public class FeedbackDAO {
	HibernateTemplate ht;  


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	public void saveFeedbac(Feedback  feedback){  
		 ht.save(feedback);  
	}  
	public void updateFeedback(Feedback feedback){  
		 ht.update(feedback);  
	}  
	public void delete(Feedback feedback){  
		 ht.delete(feedback);  
	}  
	public Feedback getById(int id){  
		Feedback feedback=(Feedback) ht.get(Feedback.class,id);  
		return feedback ;
	}  
	public List<Feedback> getFeedback(){  
		List<Feedback> list=new ArrayList<Feedback>();  
		list= ht.loadAll(Feedback.class);  
		return list;  
	}  

}