package com.hibernate.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;
import com.hibernate.entity.Teacher;
import com.hibernate.entity.TeacherDetails;

public class RtriveTeacherAndCourses {
	public static void main(String [] args) {
		SessionFactory factory = new Configuration()
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
			
			Teacher t1=session.get(Teacher.class, 2);
			Teacher t2=session.get(Teacher.class, 3);
			
			//Get course of teachers
			System.out.println("Courses "+t1.getCourses());
			System.out.println("Courses "+t2.getCourses());
			
			session.beginTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
