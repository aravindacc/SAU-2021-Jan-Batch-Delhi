package org.REST.resources;

import java.util.List;


import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;


import org.REST.model.Student;
import org.REST.service.StudentService;

@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentInfo {

	StudentService studentService= new StudentService();
	
	@GET
	public List<Student> getStudent()
	 {
		return studentService.getAllStudent();
	}
	
	@POST
	public Student addStudent(Student student) 
	{
		return studentService.addStudent(student);
	}
	
	@PUT
	@Path("/{studentId}")
	public Student updateStudent(@PathParam("studentId") long id, Student student)
	 {
		student.setId(id);
		return studentService.updateStudent(student);
	}
	
	@DELETE
	@Path("/{studentId}")
	public void deleteStudent(@PathParam("studentId") long id)
	 {
		studentService.removeStudent(id);
	}
	
	
	@GET
	@Path("/{studentId}")
	public Student getStudent(@PathParam("studentId") long id)
	 {
		return studentService.getStudent(id);
	}
}
