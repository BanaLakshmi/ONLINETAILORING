package com.example.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("bdao")
public class BranchDAO {
	HibernateTemplate ht;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	@Transactional
	public void create(Branch branch)
	{
		ht.save(branch);
	}
	public List<Branch> read()
	{
		return ht.loadAll(Branch.class);
	}
	
	
	
	
	public Branch read(String bid)
	{
		return ht.get(Branch.class, bid);
	}
	
	@Transactional
	public void update(Branch branch) {
		ht.update(branch);
	}
	
	@Transactional
	public void delete(Branch branch)
	{
		ht.delete(branch);
	}
	
//	public static void main(String[] args) {
//		Branch branch =new Branch("B00027", "K.K. Nagar", "Hyderabad");
//		//BranchDAO bdao=new BranchDAO();
//		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
//		BranchDAO bdao=(BranchDAO) ctx.getBean("bdao");
//		HibernateTemplate ht=(HibernateTemplate) ctx.getBean("ht");
//		bdao.setHt(ht);
//		bdao.update(branch);
////		bdao.create(branch);
////		List<Branch> branches = bdao.read();
////		for(Branch b : branches)
////			System.out.println(b);
//		System.out.println("Check db");
//	}
	
}
