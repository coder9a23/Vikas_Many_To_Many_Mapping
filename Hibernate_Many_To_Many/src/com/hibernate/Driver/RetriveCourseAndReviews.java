package com.hibernate.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;
import com.hibernate.entity.Teacher;
import com.hibernate.entity.TeacherDetails;

public class RetriveCourseAndReviews {
	public static void main(String args[]) {
	
	SessionFactory factory=new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Teacher.class)
			.addAnnotatedClass(TeacherDetails.class)
			.addAnnotatedClass(Course.class)
			.addAnnotatedClass(Review.class)
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
	
	Session session=factory.getCurrentSession();
	try {
		session.beginTransaction();
		Course c1=session.get(Course.class,7);
		Course c2=session.get(Course.class,8);
		System.out.println("Teacher "+c1);
		
		//get reviews of courses
		System.out.println("Reviews "+c1.getReviews());
		System.out.println("Reviews "+c2.getReviews());
	
		session.beginTransaction().commit();
	}
	finally {
		session.close();
		factory.close();
	}
	}
}