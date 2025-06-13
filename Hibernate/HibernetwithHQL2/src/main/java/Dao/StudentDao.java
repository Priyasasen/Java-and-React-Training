package Dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
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
		
      Session session=factory.openSession();
		
		Transaction txt=session.beginTransaction();
		NativeQuery<Student> q=session.createNativeQuery("delete from student where rollno=:rollno", Student.class);
		q.setParameter("rollno", rno);
		int r=q.executeUpdate();
		if(r>0)
		{
			System.out.println("Removed");
			}
		else
		{
			System.out.println("Not Found");
	
		}
 	txt.commit();	
		}

	public void updateStudent(int rollno, String newName, double newMarks) {
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    Query q = session.createNativeQuery("update student set name = :name, marks = :marks where rollno = :rollno");
	    q.setParameter("name", newName);
	    q.setParameter("marks", newMarks);
	    q.setParameter("rollno", rollno);
	    int r = q.executeUpdate();
	    if (r > 0) {
	        System.out.println("Student updated successfully.");
	    } else {
	        System.out.println("No student found with this roll number.");
	    }
	    tx.commit();
	    session.close();
	}


	public void ShowData() {
		
		
		Session session=factory.openSession();
		
		
		Query<Student> query=session.createNamedQuery("Student.findAll", Student.class);
		 
		
		List<Student> usersList=query.list();
		
		
		
		
		
	List<Student> students=	 query.list();
 
	for(Student s : students )	
	{
		System.out.println(s.toString());
		
	}
	
		
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
	public void removeStudentByHql(int rno) {
		
	      Session session=factory.openSession();
			
			Transaction txt=session.beginTransaction();
		    Query <Student>Q=session.createNamedQuery("Student.removeByStudentHql");
			Q.setParameter("rollno", rno);
			int r=Q.executeUpdate();
			if(r>0)
			{
				System.out.println("Removed");
				}
			else
			{
				System.out.println("Not Found");
		
			}
	 	txt.commit();	
			}

	@Override
	public void removeStudentByHql() {
		// TODO Auto-generated method stub
		
	}
 
	

	 
	
    

}
