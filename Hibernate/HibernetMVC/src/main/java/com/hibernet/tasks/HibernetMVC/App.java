package com.hibernet.tasks.HibernetMVC;

import Connection.StudentConn;
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
    	
    	StudentDao dao = new StudentDao();
    	dao.ShowData();
    	
        System.out.println( "Hello World!" );
    }
    
    
}