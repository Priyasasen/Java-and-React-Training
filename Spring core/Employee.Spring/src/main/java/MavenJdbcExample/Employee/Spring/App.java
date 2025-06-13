package MavenJdbcExample.Employee.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
     ApplicationContext con = new ClassPathXmlApplicationContext("beans.xml");
   	 
   	  Employee e1=(Employee)con.getBean("e1");
    	// Employee e22=(Employee)con.getBean("e2");
   	  
   	  System.out.println(e1.toString());
   	  
   	  Contactinfo c = e1.getC1();
   	  
   	  
   	System.out.println(c.toString());
   	    
    }
    
}




