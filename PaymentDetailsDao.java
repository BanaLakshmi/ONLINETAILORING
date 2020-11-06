package com.example.demo;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("Pdao")
public class PaymentDetailsDao {
	HibernateTemplate ht;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	@Transactional
	public PaymentDetails createPaymentDetails(PaymentDetails paymentDetails)
	{
		ht.save(paymentDetails);
		return paymentDetails;
	}
	public List<PaymentDetails> read()
	{
		return ht.loadAll(PaymentDetails.class);
	}
	
	public PaymentDetails readPaymentDetails(String categoryId)
	{
		return ht.get(PaymentDetails.class, categoryId);
	}
	
	@Transactional
	public void updatePaymentDetails(PaymentDetails paymentDetails) {
		ht.update(paymentDetails);
	}
	
	@Transactional
	public void deletePaymentDetails(PaymentDetails paymentDetails)
	{
		ht.delete(paymentDetails);
	}


}
