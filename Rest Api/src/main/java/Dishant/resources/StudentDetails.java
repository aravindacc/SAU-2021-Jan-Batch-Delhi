package org.Dishant.REST.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.Dishant.REST.model.Student;
import org.Dishant.REST.service.StudentService;

@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentDetails {

	StudentService studentService= new StudentService();
	
	@GET
	public List<Student> getPerson() {
		return studentService.getAllPerson();
	}
	
	@POST
	public Student addPerson(Student student) {
		return studentService.addPerson(student);
	}
	
	@PUT
	@Path("/{personId}")
	public Student updatePerson(@PathParam("personId") long id, Student student) {
		student.setId(id);
		return studentService.updatePerson(student);
	}
	
	@DELETE
	@Path("/{personId}")
	public void deletePerson(@PathParam("personId") long id) {
		studentService.removePerson(id);
	}
	
	
	@GET
	@Path("/{personId}")
	public Student getPerson(@PathParam("personId") long id) {
		return studentService.getPerson(id);
	}
}
