package pojo;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Pattern {
	@Id
	private int patternId;
	private String pattern;
	private double cost;
	
	public Pattern() {
		
	}

	public Pattern(int patternId, String pattern, double cost) {
		super();
		this.patternId = patternId;
		this.pattern = pattern;
		this.cost = cost;
	}

	public int getPatternId() {
		return patternId;
	}

	public void setPatternId(int patternId) {
		this.patternId = patternId;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Pattern [patternId=" + patternId + ", pattern=" + pattern + ", cost=" + cost + "]";
	}
	
	


}
