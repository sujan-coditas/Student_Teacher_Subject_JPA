package dao;

import model.Course;
import model.Student;
import model.Subject;
import model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements dao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sujan");
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public void insertData() throws IOException {
        EntityManager em=emf.createEntityManager();
        EntityTransaction transaction=em.getTransaction();
        transaction.begin();

        System.out.println("Enter Teacher Name");
        String teachername = bf.readLine();
        System.out.println("Enter Joining Date (yyyy-mm-dd)");
        Date joiningDate = Date.valueOf(bf.readLine());

        Teacher teacher =new Teacher();
        teacher.setTeacherName(teachername);
        teacher.setDateOfJoining(joiningDate);

        System.out.println("Enter Subject Name");
        String subjectName= bf.readLine();

        Subject subject=new Subject();
        subject.setSubName(subjectName);
        em.persist(subject);
        teacher.setSubject(subject);


        System.out.println(" how many students you want to enter ?");
        int studentCount= Integer.parseInt(bf.readLine());

        List<Student> studentList=new ArrayList<Student>();
        for(int i=0;i<studentCount;i++) {
            System.out.println("Enter Student Name");
            String studentName = bf.readLine();
            System.out.println("Enter Student Age");
            int StudentAge = Integer.parseInt(bf.readLine());

            Student student = new Student();
            student.setStudentName(studentName);
            student.setStudentAge(StudentAge);
            student.setTeacher(teacher);
            studentList.add(student); 
            em.persist(student);
            studentList.add(student);
        }
        teacher.setStudent(studentList);
        em.persist(teacher);
        transaction.commit();
        System.out.println("Data added !! ");
        em.close();


    }

    public void updateData() {

    }

    public void deleteData() {

    }
    public void insertStudent() throws IOException, ParseException {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        System.out.println("Enter student ID:");
        int studentID = Integer.parseInt(bf.readLine());

        Student student = entityManager.find(Student.class, studentID);

        System.out.println("Enter the number of courses to add:");
        int courseCount = Integer.parseInt(bf.readLine());

        List<Course> courseList = new ArrayList<Course>();
        for (int i = 0; i < courseCount; i++) {
            System.out.println("Enter course ID:");
            int courseID = Integer.parseInt(bf.readLine());

            Course course = entityManager.find(Course.class, courseID);
            courseList.add(course);
        }

        System.out.println("Adding courses to the student...");
        student.setCourse(courseList);

        entityManager.persist(student);

        entityManager.getTransaction().commit();
        entityManager.close();



    }
    public void insertCourseDetails() throws IOException {
        EntityManager em= emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();

        tx.begin();

//        System.out.println("Enter student ID :");
//        int studentID= Integer.parseInt(bf.readLine());
//
//        Student student = em.find(Student.class,studentID);
//        em.persist(student);
//
//        System.out.println("total courses to add:  ");
//        int coursecount= Integer.parseInt(bf.readLine());
//
//        List<Course> courseList=new ArrayList<Course>();
//        for(int i=0;i<coursecount;i++){
//            System.out.println("Enter course id :");
//            int cid= Integer.parseInt(bf.readLine());
//
//            Course course= em.find(Course.class,cid);
//            courseList.add(course);
//            em.persist(course);
//
//        }
//        System.out.println("List done");
//        student.setCourse(courseList);
//        em.persist(student);
//        tx.commit();
//        em.close();

        System.out.println("Enter Course Name :");
        String courseName= bf.readLine();
        System.out.println("Enter Start Date (yyyy-mm-dd)");
        Date startDate = Date.valueOf(bf.readLine());
        System.out.println("Enter end Date (yyyy-mm-dd)");
        Date endDate = Date.valueOf(bf.readLine());

        Course course= new Course();
        course.setCourseName(courseName);
        course.setStartingDate(startDate);
        course.setEndingDate(endDate);


        em.persist(course);



    }
}
