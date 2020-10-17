
import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;   


@SuppressWarnings("hiding")
public class ResolutionDAO<HibernateTemplate> {
	
		HibernateTemplate ht;  


		public HibernateTemplate getHt() {
			return ht;
		}
		public void setHt(HibernateTemplate ht) {
			this.ht = ht;
		}
		public void saveResolution(Resolution  resolution){  
			((org.springframework.orm.hibernate5.HibernateTemplate) ht).save(resolution);  
		}  
		public void updateResolution(Resolution resolution){  
			((org.springframework.orm.hibernate5.HibernateTemplate) ht).update(resolution);  
		}  
		public void deleteResolution(Resolution resolution){  
			((org.springframework.orm.hibernate5.HibernateTemplate) ht).delete(resolution);  
		}  
		public Resolution getById(int id){  
			Resolution resolution=(Resolution)((org.springframework.orm.hibernate5.HibernateTemplate) ht).get(Resolution.class,id);  
			return resolution;  
		}  
		public List<Resolution> getResolution(){  
			List<Resolution> list=new ArrayList<Resolution>();  
			list=((org.springframework.orm.hibernate5.HibernateTemplate) ht).loadAll(Resolution.class);  
			return list;  
		}  
	} 


