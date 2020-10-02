package com.mahidhar.project;

public class Pattern {
	private int patternId;
	private String pattern;
	private double cost;

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

}