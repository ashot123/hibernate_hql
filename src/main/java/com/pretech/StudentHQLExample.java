package com.pretech;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentHQLExample {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Save entity
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student student = new Student();
        student.setName("Raj");
        student.setStandard("10th Standard");
        session.save(student);
        tx.commit();

        System.out.println("Record save successfully");
        System.out.println("Executing Select Query");


        // Select by name
        Query query = session.createQuery("from Student where name=:name");
        query.setParameter("name", "Raj");
        List list = query.list();
        for (Object aList : list) {
            Student stud = (Student) aList;
            System.out.println(stud.getName());
            System.out.println(stud.getStandard());
        }

        System.out.println("Executing Update");


        // Update "standard" by name
        Transaction tx1 = session.beginTransaction();
        Query queryUpdate = session.createQuery("update Student set standard = :standard where name = :name");

        queryUpdate.setParameter("name", "Raj");
        queryUpdate.setParameter("standard", "Third Standard");
        int result = queryUpdate.executeUpdate();
        tx1.commit();

        System.out.println("Student record updated " + result);


        // Delete by name
        System.out.println("Executing Delete ");
        Transaction tx2 = session.beginTransaction();
        Query queryDelete = session.createQuery("delete from Student where name = :name");
        queryDelete.setParameter("name", "Raj");
        int result1 = queryUpdate.executeUpdate();
        tx2.commit();
        System.out.println("Student record deleted " + result1);

    }

}