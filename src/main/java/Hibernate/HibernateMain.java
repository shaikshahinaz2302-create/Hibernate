package Hibernate;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;
import java.util.Scanner; 

public class HibernateMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Bank Name : ");
		String bankName = sc.nextLine();
		
		System.out.println("Enter Account Number: ");
		int accNo = sc.nextInt();
		sc.nextLine(); 
		
		System.out.println("Enter Customer Name: ");
		String custName = sc.nextLine();
		
	
		Configuration cfg = new Configuration().configure("hibernate-cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.createNativeQuery("insert into banking values(:no,:name,:bankname)")
		.setParameter("no", 123).setParameter("name", "hai").setParameter("bankname", "sbi").executeUpdate();
		
		Bank b = new Bank(bankName, accNo, custName);
		
		session.persist(b);
		tx.commit();
		
		System.out.println("Values are Inserted successfully!");
		
	}	
}
