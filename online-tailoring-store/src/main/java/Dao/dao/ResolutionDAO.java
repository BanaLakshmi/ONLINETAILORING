package Dao.dao;


import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;

import pojo.Resolution;   



public class ResolutionDAO {
	
		HibernateTemplate ht;  


		public HibernateTemplate getHt() {
			return ht;
		}
		public void setHt(HibernateTemplate ht) {
			this.ht = ht;
		}
		public void saveResolution(Resolution  resolution){  
			ht.save(resolution);  
		}  
		public void updateResolution(Resolution resolution){  
			 ht.update(resolution);  
		}  
		public void deleteResolution(Resolution resolution){  
			 ht.delete(resolution);  
		}  
		public Resolution getById(int id){  
			Resolution resolution=(Resolution) ht.get(Resolution.class,id);  
			return resolution;  
		}  
		public List<Resolution> getResolution(){  
			List<Resolution> list=new ArrayList<Resolution>();  
			list= ht.loadAll(Resolution.class);  
			return list;  
		}  
	} 


