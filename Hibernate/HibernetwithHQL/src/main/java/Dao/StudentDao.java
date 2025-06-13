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
        query.setFirstResult(0);      
        query.setMaxResults(5); 
        List<Student> students = query.list();

        for (Student s : students) {
            System.out.println(s);
        }

        session.close();
    }

	@Override
	public void searchHQLName(String name) {
		
			Session session=factory.openSession();
	 
			
			
			Query <Student>Q=session.createQuery("from Student where name=:name",Student.class);
			Q.setParameter("name", name);
			 List<Student> usersList=  Q.list();
			
			 for(Student  u : usersList )
			 {
				 System.out.println(u.toString());
			 }
			
			 session.close(); 
			
		}
	public List<Student> getAllStudents() {
	    Session session = factory.openSession();
	    Query<Student> query = session.createQuery("from Student", Student.class);
	    List<Student> students = query.list();
	    session.close();
	    return students;
	}

	@Override
	public void displayHighMarks() {
		// TODO Auto-generated method stub
		
	}
	
	public void removeByRollNo(int rollno)
	{
		Session session=factory.openSession();
		Transaction txTransaction=session.beginTransaction();
		Query <Student>Q=session.createQuery(" delete from Student where rollno=:rollno");
		Q.setParameter("rollno", rollno);
		int r=Q.executeUpdate();
		if(r>0)
		{
			System.out.println("Removed");
		}
		else {
			{
				System.out.println("Not Found");
			}
		}
 
		txTransaction.commit();
		
	}
	 public void updateStudentName(int rollno, String newName) {
		    Session session=factory.openSession();
			Transaction txTransaction=session.beginTransaction();
	        Query<Student>Q= session.createQuery("update Student set name = :name where rollno = :rollno");
	        Q.setParameter("name", newName);
	        Q.setParameter("rollno", rollno);

	        int r =Q.executeUpdate();

	        if (r > 0) {
	            System.out.println("Student name updated successfully.");
	        } else {
	            System.out.println("No student found with this roll number.");
	        }
	    	txTransaction.commit();
	    }

	@Override
	public void updateStudentNameByRoll() {
		// TODO Auto-generated method stub
		
	}
 
	

	 
	
    

}
