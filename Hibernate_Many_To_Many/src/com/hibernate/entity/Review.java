package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	private String comment;
	
	//We shouldn't use CascadeType.delete because we don't want when course will delete than 
	//teacher delete bcoz a teacher can have more than one courses
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,
							CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="course_id")
	private Course courses;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Review(String comment) {
		super();
		this.comment = comment;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Course getCourses() {
		return courses;
	}

	public void setCourses(Course courses) {
		this.courses = courses;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + ", courses=" + courses + "]";
	}

	
}
