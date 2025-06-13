package MavenJdbcExample.SpringExample;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args)
    {
       
    	ApplicationContext context = new AnnotationConfigApplicationContext(Address.class);
    	Student student = (Student) context.getBean("s1");
    	System.out.println(student);
        context.close();
    	
    	
    }
    
    
    
}

 



