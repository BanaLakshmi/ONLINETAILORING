package com.mahi.spring.Onlinetailoringproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class PatternDao {
	HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void savePattern(Pattern pattern) {
		ht.save(pattern);
	}

	public void updatePattern(Pattern pattern) {
		ht.update(pattern);
	}

	public void deletePattern(Pattern pattern) {
		ht.delete(pattern);
	}
	
	public Pattern getById(int id) {
		Pattern pattern=(Pattern)ht.get(Pattern.class,id);
		return pattern;
	}
	public List<Pattern> getPatterns(){
		List<Pattern> list=new ArrayList<Pattern>();
		list=ht.loadAll(Pattern.class);
		return list;
	}

}
