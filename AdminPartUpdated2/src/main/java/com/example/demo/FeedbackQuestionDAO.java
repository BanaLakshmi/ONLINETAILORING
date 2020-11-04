package com.example.demo;

import java.util.List;


import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component("Fdao")
public class FeedbackQuestionDAO {
	HibernateTemplate ht;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Transactional
	public FeedbackQuestion create(FeedbackQuestion feedbackQuestion) {
		ht.save(feedbackQuestion);
		return feedbackQuestion;
	}

	
	@Transactional
	public FeedbackQuestion update(FeedbackQuestion feedbackQuestion) {
		ht.update(feedbackQuestion);
		return feedbackQuestion;
	}

	@Transactional
	public void delete(FeedbackQuestion feedbackQuestion) {
		ht.delete(feedbackQuestion);
	}
	

	public List<FeedbackQuestion> read()
	{
		return ht.loadAll(FeedbackQuestion.class);
	}
	
	public FeedbackQuestion read(int questionId)
	{
		return ht.get(FeedbackQuestion.class, questionId);
	}
	
}
