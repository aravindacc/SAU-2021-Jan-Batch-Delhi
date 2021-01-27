package Question1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;



public class ReteriveEmployees {

	public static void main(String[] args) {
		
		ApplicationContext factory = new FileSystemXmlApplicationContext("q1_spring.xml");
		Employee emp = (Employee)factory.getBean("employee");
		
		System.out.println("Set Example");
		emp.printWork1();
		System.out.println("Map Example");
		emp.printWork_in_year();
		System.out.println("This is values from external files ") ;
		emp.showWorkA();

	}

}
