

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Feedback {
	@Id
	private int feedbackId;
	private Date feedbackDate;
	private int orderId,userId, questionId;
	private String  answer;
	
	
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Date getFeedbackDate() {
		return feedbackDate;
	}
	public String getFeedbackDate1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(this.feedbackDate);
	}
	public void setFeedbackDate1(String feedbackDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    this.feedbackDate = sdf.parse(feedbackDate);
	}


	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Feedback(Date feedbackDate, int orderId, int userId, int questionId, String answer) {
		super();
		this.feedbackDate = feedbackDate;
		this.orderId = orderId;
		this.userId = userId;
		this.questionId = questionId;
		this.answer = answer;
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}

