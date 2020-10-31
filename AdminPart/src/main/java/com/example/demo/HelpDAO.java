package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("hdao")
public class HelpDAO {
	HibernateTemplate ht;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Transactional
	public Help create(Help help) {
		ht.save(help);
		return help;
	}

	
	@Transactional
	public Help update(Help help) {
		ht.update(help);
		return help;
	}

	@Transactional
	public void delete(Help help) {
		ht.delete(help);
	}

	public List<Help> read()
	{
		return ht.loadAll(Help.class);
	}
	
	public Help read(int requestId)
	{
		return ht.get(Help.class, requestId);
	}
	
}
