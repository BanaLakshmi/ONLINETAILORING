public class feedbackQuestion {
	private String questionId, question;

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public feedbackQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public feedbackQuestion(String questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

}
