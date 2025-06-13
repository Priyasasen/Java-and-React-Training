package Dao;

import model.Student;

public interface DaoStudentI {
	
	void saveData(Student s);
	void removeByRoll(int rno);

	void updateStudent(int rollno, String newName, double newMarks);
	
	void removeStudentByHql();
	
	
	void searchHQLName(String snm);
	
	void displayHighMarks();
	
	void updateStudentNameByRoll();
	void ShowData();

}
