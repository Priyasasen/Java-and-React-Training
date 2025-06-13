package com.hibernet.tasks.HibernetHQL;

import Dao.StudentDao;
import Service.StudentService;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
  	
    	StudentService service= new StudentService();
    	//service.saveStudent();
    	//service.removeByRoll();
    	//service.updateStudent();
    	//service.searchByName();
    	// service.removeStudentByRollNo();
    	service.removeStudentByHql();
    	//service.updateStudentNameByRoll();
    	//service.displayHighMarks();
    	//service.ShowData();
    	//StudentDao dao = new StudentDao();
    	//dao.ShowData();
        System.out.println( "Hello World!" );
       
    }
    
    
    
    
}
