

import javax.persistence.Entity;

@Entity
@Table(name="FeedbackQuestion")
public class FeedbackQuestion {
	@Id @GeneratedValue
	private int questionId;
	private String  question;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public FeedbackQuestion(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	public FeedbackQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FeedbackQuestion [questionId=" + questionId + ", question=" + question + "]";
	}

}
