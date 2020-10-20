package Dao.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import pojo.BottomMeasurement;



public class BottomMeasurementDao {
	HibernateTemplate ht;  


	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	public void saveBottomMeasurement(BottomMeasurement bottomMeasurement){  
		ht.save(bottomMeasurement);  
	}  
	
	public void updateBottomMeasurement(BottomMeasurement bottomMeasurement){  
		ht.update(bottomMeasurement);  
	}  
	
	public void deleteBottomMeasurement(BottomMeasurement bottomMeasurement){  
		ht.delete(bottomMeasurement);  
	}  
	
	public BottomMeasurement getById(int id){  
		BottomMeasurement bottomMeasurement=(BottomMeasurement)ht.get(BottomMeasurement.class,id);  
		return bottomMeasurement;  
	}  
	
	public List<BottomMeasurement> getBottomMeasurement(){  
		List<BottomMeasurement> list=new ArrayList<BottomMeasurement>();  
		list=ht.loadAll(BottomMeasurement.class);  
		return list;  
	}  
}
