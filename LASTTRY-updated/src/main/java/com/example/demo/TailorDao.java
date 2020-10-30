package com.example.demo;



import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;



public class TailorDao {
	HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void saveTailor(Tailor tailor) {
		ht.save(tailor);
	}

	public void updateTailor(Tailor tailor) {
		ht.update(tailor);
	}

	public void deleteTailor(Tailor tailor) {
		ht.delete(tailor);
	}

	public Tailor getById(int id) {
		Tailor tailor = (Tailor) ht.get(Tailor.class, id);
		return tailor;
	}

	public List<Tailor> getTailors() {
		List<Tailor> list = new ArrayList<Tailor>();
		list = ht.loadAll(Tailor.class);
		return list;

	}

}
