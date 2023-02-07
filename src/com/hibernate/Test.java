package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		//step-1:- create object of configuration+configure file pass
		System.out.println("line 1");
		Configuration configuration = new Configuration(); // creating configuration object

		System.out.println("line 2");
		configuration.configure("hibernate.cfg.xml"); // this method is used to load cfg file

		// step-2:- buildsessionfactory
		System.out.println("line 3");
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// step-3:-opensession
		Session session = sessionFactory.openSession();

		// step-4:- begitransactionn
		Transaction transaction = session.beginTransaction();

		// insert data into database
		Student student = new Student();

		// how to set the value into object student
		// student.setId(10);
		student.setFirstName("Akhilesh");
		student.setLastName("Gargatte");
		
		//cant insert multiple record at a time...
		Student student1 = new Student();
		student1.setFirstName("Ajinkya");
		student1.setLastName("Satpute");

		session.save(student);
		session.save(student);
		session.close();
		System.out.println("Record saved successfully...");
	}
}


