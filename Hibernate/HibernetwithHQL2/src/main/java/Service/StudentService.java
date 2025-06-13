package Service;

import java.util.List;
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
	
	public void searchByName() {
		
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter search name:");
        String name = sc.nextLine();

        dao.searchHQLName(name); 
		
	}
	
	public void displayHighMarks() {
	    List<Student> students = dao.getAllStudents(); // 

	    students.stream()
	        .filter(s -> s.getMarks() > 800)
	        .map(Student::getName)
	        .forEach(System.out::println);
	
    }
    public void updateStudentNameByRoll() {
        System.out.print("Enter roll number: ");
        int rollno = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        dao.updateStudentName(rollno, name);
    }

	public void removeStudentByHql() {
		// TODO Auto-generated method stub
		
	}
    

}