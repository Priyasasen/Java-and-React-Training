package Dao;

import model.Student;

public interface DaoStudentI {
	
	void saveData(Student s);
	void removeByRoll(int rno);

	void updateStudent(int rollno, String newName, double newMarks);

}
