package Service;

import java.util.Scanner;

import Dao.StudentDao;
import model.Student;

public class StudentService {

	StudentDao dao;
	Scanner sc;

	public StudentService() {
		sc = new Scanner(System.in);
		dao = new StudentDao();
	}

	public void saveStudent() {
		Student s = new Student(); 

		System.out.println("Enter RollNo: ");
		s.setRollno(sc.nextInt());

		System.out.println("Enter Name: ");
		sc.nextLine(); 
		s.setName(sc.nextLine());

		System.out.println("Enter Marks: ");
		s.setMarks(sc.nextDouble());

		dao.saveData(s);
		System.out.println("Student saved successfully.");
	}

	public void removeByRoll() {
		System.out.println("Enter RollNo to remove: ");
		int rno = sc.nextInt();
		dao.removeByRoll(rno);
	}
	public void updateStudent() {
		System.out.println("Enter RollNo to update: ");
		int rno = sc.nextInt();
		sc.nextLine(); 

		System.out.println("Enter new Name: ");
		String name = sc.nextLine();

		System.out.println("Enter new Marks: ");
		double marks = sc.nextDouble();

		dao.updateStudent(rno, name, marks);
	}

}