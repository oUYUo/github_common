package com.edu;

public class HelloBean {
	private String name;
	private String course;
	private Double score;
	public HelloBean(){}
	public HelloBean(String name,String course,Double score){
		this.name=name;this.course=course;this.score=score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
}
