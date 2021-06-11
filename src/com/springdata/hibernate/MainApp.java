package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.hibernate.model.Employee;

public class MainApp {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			 session.createQuery("update Employee emp set fullName= 'Ahmed Mohamed' where emp.id=1 ").executeUpdate();
			
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			session.close();
		}
			
	}
}


//SessionFactory sessionFactory = new Configuration()
//								.configure("hibernate.cfg.xml")
//								.addAnnotatedClass(Employee.class)
//								.buildSessionFactory();
//Session session = sessionFactory.getCurrentSession();
//
//// TO Save Object
//// Declare Object
////Employee emp = new Employee("Mostafa Mahmoud", 40, "Giza");
////emp.setFullName("Ahmed Elsheikh");
////emp.setAge(25);
////emp.setAddress("Cairo");
//
//long id = 1;
//
//try {
//// begin transaction
//session.beginTransaction();
//// Update EMployee
////Employee emp = new Employee("Amira Ahmed", 25, "Egypt");
////emp.setId(id);
////session.update(emp);
//// To Get Employee By ID
////Employee emp = session.get(Employee.class, id);
//
//// Delete Employee
//Employee emp = new Employee();
//emp.setId((long) 3); 
//session.delete(emp);
//// save object
////session.save(emp);
//// commmit transaction
//session.getTransaction().commit();
//System.out.println("FullName: " +emp.getFullName() + " " + "Address: "+ emp.getAddress());
//}catch(Exception e) {
//System.out.println(e.toString());
//}finally {
//session.close();
//}
//
//
//
//
//////Connect To DB
////String url = "jdbc:mysql://localhost:3306/employee";
////String username = "root";
////String password = "";
////
////try {
////
////	Connection conn = DriverManager.getConnection(url, username, password);
////	System.out.println("COnnected!!");
////	System.out.println(conn);
////} catch (SQLException e) {
////	// TODO Auto-generated catch block
////	e.printStackTrace();
//////	System.out.println(e.toString());
////
////}

