package com.mahi.spring.Onlinetailoringproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class TopMeasurementDao {
	HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void saveTopMeasurement(TopMeasurement topMeasurement) {
		ht.save(topMeasurement);
	}
	public void updateTopMeasurement(TopMeasurement topMeasurement) {
		ht.update(topMeasurement);
	}
	public void deleteTopMeasurement(TopMeasurement topMeasurement) {
		ht.delete(topMeasurement);
	}
	public TopMeasurement getById(int id) {
		TopMeasurement topMeasurement = (TopMeasurement) ht.get(TopMeasurement.class, id);
		return topMeasurement;
	}

	public List<TopMeasurement> getTopMeasurements() {
		List<TopMeasurement> list = new ArrayList<TopMeasurement>();
		list = ht.loadAll(TopMeasurement.class);
		return list;

	}


}
