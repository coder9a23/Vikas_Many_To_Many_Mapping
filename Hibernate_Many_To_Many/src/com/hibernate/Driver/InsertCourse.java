package com.hibernate.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;
import com.hibernate.entity.Teacher;
import com.hibernate.entity.TeacherDetails;

public class InsertCourse {

		public static void main(String [] args) {
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
				//get the teacher
				Teacher t1=session.get(Teacher.class,1);
				Teacher t2=session.get(Teacher.class,2);
				Teacher t3=session.get(Teacher.class,3);
				
				//create some course
				Course c1=new Course("Java");
				Course c2=new Course("Python");
				Course c3=new Course("C#");
				Course c4=new Course("C+");
				Course c5=new Course("DS");
				Course c6=new Course("Ruby");
				
				//add course to teacher
				t1.add(c6);
				t1.add(c5);
				t2.add(c4);
				t2.add(c3);
				t3.add(c2);
				t3.add(c1);
				
				//save the courses
				session.save(c6);
				session.save(c5);
				session.save(c4);
				session.save(c3);
				session.save(c2);
				session.save(c1);
				
				//commt the session
				session.beginTransaction().commit();
				
			}
			finally {
				session.close();
				factory.close();
			}
		}
}
