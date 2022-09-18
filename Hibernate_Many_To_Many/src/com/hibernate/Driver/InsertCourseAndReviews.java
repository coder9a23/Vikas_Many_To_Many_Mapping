package com.hibernate.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;
import com.hibernate.entity.Teacher;
import com.hibernate.entity.TeacherDetails;

public class InsertCourseAndReviews {

		public static void main(String args[]) {
			//create sessioin factory
			SessionFactory factory=new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Teacher.class)
					.addAnnotatedClass(TeacherDetails.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Student.class)
					.addAnnotatedClass(Review.class)
					.buildSessionFactory();
	//create session
			Session session=factory.getCurrentSession();
			try {
				
				session.beginTransaction();
				
				//create the objects
				Course c1=new Course("Python2");
				Course c2=new Course("Java");
				
				//add some reviews
				c1.add(new Review("Good course"));
				c1.add(new Review("Really loved it"));
				c1.add(new Review("Awsome"));
				c1.add(new Review("Something valuable"));
				
				c2.add(new Review("Good course"));
				c2.add(new Review("Really loved it"));
				c2.add(new Review("Awsome"));
				c2.add(new Review("Something valuable"));
				
				//save course and leverage the cascade all
				System.out.println("Saving Course");
				System.out.println(c1);
				System.out.println(c1.getReviews());
				System.out.println(c2);
				System.out.println(c2.getReviews());
				session.save(c1);
				session.save(c2);
				
				session.beginTransaction().commit();
				
			}
			finally {
				session.close();
				factory.close();
				
			}
			
		}
}
