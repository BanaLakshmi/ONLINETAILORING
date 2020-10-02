import java.sql.Date;

public class feedback {
	private Date feedbackDate;
	private int orderId;
	private String userId, questionId, answer;

	public Date getFeedbackDate() {
		return feedbackDate;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public feedback(Date feedbackDate, int orderId, String userId, String questionId, String answer) {
		super();
		this.feedbackDate = feedbackDate;
		this.orderId = orderId;
		this.userId = userId;
		this.questionId = questionId;
		this.answer = answer;
	}
}