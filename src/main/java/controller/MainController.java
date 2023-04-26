package controller;

import dao.StudentDaoImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class MainController {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sujan");
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, ParseException {
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();


        boolean flag = true;
        while (flag) {
            System.out.println("Enter your choice : ");
            System.out.println("1.Enter Student & Teacher Details : ");
            System.out.println("2.Enter Courses ");
            System.out.println("3.course ");
            System.out.println("0.EXIT ");

            int choice = Integer.parseInt(bf.readLine());
            switch (choice) {
                case 1:
                studentDaoImpl.insertData();
                break;
                case 2:
                    studentDaoImpl.insertCourseDetails();
                    break;
                case 3:
                    studentDaoImpl.insertStudent();
                    break;
                case 0:
                    emf.close();
                    flag = false;
                    System.out.println("Goodbye !!");
                    break;

                default:
                    System.out.println("Enter valid option");
                    break;

            }
        }

    }
}
