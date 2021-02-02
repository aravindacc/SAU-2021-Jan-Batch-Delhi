package Q1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;



public class StudentsRetrievel {

	public static void main(String[] args) {
		
		ApplicationContext factory = new FileSystemXmlApplicationContext("q1Spring.xml");
		Student student = (Student)factory.getBean("student");
		
//		Example of SET
		student.printSubjects();
		
//		Example of MAP
		student.printSubjectAndYear();
		
//	    Values from external files
		student.showSubject();

	}

}
