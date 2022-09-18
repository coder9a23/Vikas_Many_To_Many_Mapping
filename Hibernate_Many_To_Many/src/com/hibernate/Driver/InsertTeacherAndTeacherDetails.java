package com.hibernate.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;
import com.hibernate.entity.Teacher;
import com.hibernate.entity.TeacherDetails;

public class InsertTeacherAndTeacherDetails {
		
	public static void main(String args []) {
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
			Teacher t1=new Teacher("Anmol","Jaiswal","Anmol@org.gamil");
			Teacher t2=new Teacher("Ruders","Khurana","Ruderorg@.gamil.com");
			Teacher t3=new Teacher("Ruders","Khurana","PrishaKhu@org.com");
			
			TeacherDetails td1=new TeacherDetails("Pune","Dancing");
			TeacherDetails td2=new TeacherDetails("Maharashtra","Singing");
			TeacherDetails td3=new TeacherDetails("Delhi","Crying");
			
			//associate the object
			t1.setTeacherDetails(td3);
			t2.setTeacherDetails(td2);
			t3.setTeacherDetails(td1);
			
			
			System.out.println("Saving teachre");
			//save the teacher
			session.save(t1);
			session.save(t2);
			session.save(t3);
			
			//commit the session
			session.beginTransaction().commit();
			
			
		}finally {
			
			session.close();
			factory.close();
		}
	}

}
