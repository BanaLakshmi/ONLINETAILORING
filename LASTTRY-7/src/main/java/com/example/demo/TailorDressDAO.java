package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component("tailorDressdao")
public class TailorDressDAO {
	HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	@Transactional
	public void saveTailorDress(TailorDress tailorDress) {
		ht.save(tailorDress);
		
	}
	@Transactional
	public void updateTailorDress(TailorDress tailorDress) {
		ht.update(tailorDress);
	}
	@Transactional
	public void deleteTailorDress(TailorDress tailorDress) {
		ht.delete(tailorDress);
	}

	public TailorDress getById(int id) {
		TailorDress tailorDress = (TailorDress) ht.get(TailorDress.class, id);
		return tailorDress;
	}

	public List<TailorDress> getTailorDresses() {
		List<TailorDress> list = new ArrayList<TailorDress>();
		list = ht.loadAll(TailorDress.class);
		return list;

	}
//	public TailorDress  read 1(int categoryId,String dressType,String dressKind)
//	{
//		Session session = ht.getSessionFactory().openSession();
//		Query query = session.createSQLQuery("select t.tailorId from TailorDress td join tailor t on t.tailorId=td.tailorId where td.categoryId=? and td.dressType=? and td.dressKind=?");
////				.createQuery("SELECT q From  SecretQuestions q WHERE q.userId=? AND q.a1=? AND q.a2=? AND q.a3=?");
//		query.setParameter(0, categoryId);
//		query.setParameter(1, dressType);
//		query.setParameter(2, dressKind);
//		List<TailorDress>  s = query.list();
//		if(s==null || s.size()==0) {
//			return null;
//		}
//	return s.get(0);
//	}

	public List<String> read(int categoryId, String dressType, String dressKind, String deliveryArea) {
		Session session = ht.getSessionFactory().openSession();
		String queryString = null;
		Query query = null;
		if (deliveryArea != null) {
			query = session.createSQLQuery("select t.tailorId from tailor_dress td join tailor t on t.tailorId=td.tailorId where td.categoryId=? and td.dressType=? and td.dressKind=? and t.deliveryAddress like CONCAT('%',:deliveryArea,'%')");
			query.setParameter("deliveryArea", deliveryArea);
		} else {
			query = session.createSQLQuery(
					"select t.tailorId from tailor_dress td join tailor t on t.tailorId=td.tailorId where td.categoryId=? and td.dressType=? and td.dressKind=?");
		}
		query.setParameter(0, categoryId);
		query.setParameter(1, dressType);
		query.setParameter(2, dressKind);
		List<String> s = query.list();
		if (s == null || s.size() == 0) {
			return null;
		}
		return new ArrayList<>(s.stream().collect(Collectors.toSet()));
	}
	
	public List<TailorDress> getTailorDressByTailorId(String tailorId) {
		List<TailorDress> list = new ArrayList<TailorDress>();
		list = ht.loadAll(TailorDress.class);
		List<TailorDress> filteredList  = list.stream().filter(l -> l.getTailorId().equalsIgnoreCase(tailorId)).collect(Collectors.toList());
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		DressCategoryDAO dressCategoryDAO = (DressCategoryDAO) ctx.getBean("dCdao");
		List<DressCategory> dressCategorylist = dressCategoryDAO.getDressCategories();
		 Map<Integer, String> map = new HashMap<>(); 
	        for (DressCategory dct : dressCategorylist) { 
	            map.put(dct.getCategoryId(), dct.getDressCategoery()); 
	        } 
	        filteredList.forEach(l -> {
	        	l.setTailorId(map.get(l.getCategoryId()));
	        });
		return filteredList;
	}
	
	public List<TailorDress> getPatternsOnBasisOfSelection(Integer categoryId, String dressType, String dressKind,String delArea){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");

		//DressCategoryDAO dressCategoryDAO = (DressCategoryDAO) ctx.getBean("dCdao");
		List<TailorDress> list = new ArrayList<TailorDress>();
		List<TailorDress> filteredList = null;
		if(delArea!=null && !delArea.isEmpty()) {
			TailorDao tailordao = (TailorDao) ctx.getBean("tailordao");
			 List<Tailor> tailorList =  tailordao.getTailors();
			List<Tailor> filteredtailorList =  tailorList.stream().filter(t -> t.getDeliveryAddress().contains(delArea)).collect(Collectors.toList());
			List<String> tailorIds = filteredtailorList.stream().map(l -> l.getTailorId()).collect(Collectors.toList());
			list = ht.loadAll(TailorDress.class);
			 filteredList = list.stream().filter(l -> (l.getDressType().equalsIgnoreCase(dressType) && l.getCategoryId() == categoryId
						&& l.getDressKind().equalsIgnoreCase(dressKind) && tailorIds.contains(l.getTailorId()))).collect(Collectors.toList());
		}
		else {
			list = ht.loadAll(TailorDress.class);
			 filteredList = list.stream().filter(l -> (l.getDressType().equalsIgnoreCase(dressType) && l.getCategoryId() == categoryId
					&& l.getDressKind().equalsIgnoreCase(dressKind))).collect(Collectors.toList());
		}
		
		/*
		 * List<DressCategory> dressCategorylist =
		 * dressCategoryDAO.getDressCategories(); Map<Integer, String> map = new
		 * HashMap<>(); for (DressCategory dct : dressCategorylist) {
		 * map.put(dct.getCategoryId(), dct.getDressCategoery()); }
		 * filteredList.forEach(l -> { l.setTailorId(map.get(l.getCategoryId())); });
		 */
		return filteredList;
		
	}
	public List<GetOrderDetails>  getAllOrderDetails(){
		List<GetOrderDetails> getOrderDetails= new ArrayList<>();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
		TailorDressDAO tailorDressDAO = (TailorDressDAO) ctx.getBean("tailorDressdao");
		List<Order> orders = orderDao.read();
		List<TailorDress> tailorDresses = tailorDressDAO.getTailorDresses();
		Map<Integer,TailorDress> map = tailorDresses.stream().collect(Collectors.toMap(TailorDress :: getTailorDressId, t -> t));
		for(Order order : orders) {
			GetOrderDetails getOrderDetail = new GetOrderDetails(order,map.get(order.getTailorDressId()));
			getOrderDetails.add(getOrderDetail);
		}
		return getOrderDetails;
		
	}
	
	public List<GetOrderDetails> getAllOrderDetailsByTailorId(String tailorId){
		List<GetOrderDetails> list = getAllOrderDetails();
		return list.stream().filter(l-> l.getTailorId().equalsIgnoreCase(tailorId)).collect(Collectors.toList());
	}
	public List<GetOrderDetails> getAllOrderDetailsByCustomerId(String customerId){
		List<GetOrderDetails> list = getAllOrderDetails();
		return list.stream().filter(l-> l.getCustomerId().equalsIgnoreCase(customerId)).collect(Collectors.toList());
	}
	public List<GetOrderDetails> getAllOrderDetailsByOrderId(Integer orderId){
		List<GetOrderDetails> list = getAllOrderDetails();
		return list.stream().filter(l-> l.getOrderId().equals(orderId)).collect(Collectors.toList());
	}
	


}
