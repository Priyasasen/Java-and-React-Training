package Dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Connection.StudentConn;
import model.Student;

public class StudentDao implements DaoStudentI {

	SessionFactory factory;

	public StudentDao() {
		factory = StudentConn.getSessionFactory();
	}

	public void saveData(Student s) {
		Session session = factory.openSession();
		Transaction txt = session.beginTransaction();
		session.save(s);
		txt.commit();
		session.close();
	}

	@Override
	public void removeByRoll(int rno) {
		Session session = factory.openSession();
		Transaction txt = session.beginTransaction();

		Student s = session.find(Student.class, rno);

		if (s == null) {
			System.out.println("Not Found");
		} else {
			session.delete(s);
			txt.commit();
			System.out.println("Deleted successfully.");
		}

		session.close();
	}

	public void updateStudent(int rollno, String newName, double newMarks) {
		Session session = factory.openSession();
		Transaction txt = session.beginTransaction();

		Student s = session.find(Student.class, rollno);

		if (s == null) {
			System.out.println("Student not found.");
		} else {
			s.setName(newName);
			s.setMarks(newMarks);
			session.update(s);
			txt.commit();
			System.out.println("Student updated successfully.");
		}

		session.close();
	}
    public void ShowData() {
        Session session = factory.openSession();
        Query<Student> query = session.createQuery("from Student", Student.class);
        List<Student> students = query.list();

        for (Student s : students) {
            System.out.println(s);
        }

        session.close(); // don't forget to close session
    }

}
