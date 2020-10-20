package Dao.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import pojo.Bill;

public class BillDao {
	HibernateTemplate ht;  


public HibernateTemplate getHt() {
	return ht;
}
public void setHt(HibernateTemplate ht) {
	this.ht = ht;
}

public void saveBill(Bill bill){  
	ht.save(bill);  
}  

public void updateBill(Bill bill){  
	ht.update(bill);  
}  

public void deleteBill(Bill bill){  
	ht.delete(bill);  
}  
 
public Bill getById(int id){  
	Bill bill=(Bill)ht.get(Bill.class,id);  
	return bill;  
}  

public List<Bill> getBill(){  
	List<Bill> list=new ArrayList<Bill>();  
	list=ht.loadAll(Bill.class);  
	return list;  
}  
}


