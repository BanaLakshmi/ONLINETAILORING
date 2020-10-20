package pojo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SecretQuestions")
public class SecretQuestions {
	@Id @GeneratedValue
	private int sqId ;
	private int userId ;
	private String answer1;
	private String answer2;
	private String answer3;
	public int getSqId() {
		return sqId;
	}
	public void setSqId(int sqId) {
		this.sqId = sqId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public SecretQuestions() {
		super();
	}
	public SecretQuestions(int sqId, int userId, String answer1, String answer2, String answer3) {
		super();
		this.sqId = sqId;
		this.userId = userId;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
	}
	public SecretQuestions(int userId, String answer1, String answer2, String answer3) {
		super();
		this.userId = userId;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
	}
	

	
	

}
