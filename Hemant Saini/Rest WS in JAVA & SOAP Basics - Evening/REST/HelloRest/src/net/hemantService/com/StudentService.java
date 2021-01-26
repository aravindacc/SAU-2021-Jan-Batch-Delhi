package net.hemantService.com;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.hemantModel.com.Student;
  
@Path("student")
public class StudentService{
	
	/* Function to load on /student(by default) resource */
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMsg() {
    	//System.out.println("called");
    	return "Hello Student";
    }
	
	/* Function to get a list of students */
    @GET
    @Path("/allStudents")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getStudents() {
    	List<Student> list = new ArrayList<Student>();
    	list.add(new Student(101,"Hemant",22));
    	list.add(new Student(102,"Indu",25));
    	GenericEntity<List<Student>> genericEntity = new GenericEntity<List<Student>>(list){};
		return (Response.ok(genericEntity, MediaType.APPLICATION_JSON).build());
    }
    
    /* Function to add a student with XML file*/
    @POST
    @Path("/addStudent")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response addStudent( Student student ) throws URISyntaxException {
        if(student == null){
            return Response.status(400).entity("Please provide an appropriate XML file for students").build();
        }
         
        //Here is the code for adding student to some database but 
        //as I am leaning Rest so I have not done it.
        return Response.status(400).entity("Student Added").build();
    }
    
    /* Function to delete a student */
    @DELETE
    @Path("/deleteStudent/{id}")
    public Response deleteEmployeeById(@PathParam("id") Integer id) { 
    	
    	//Code to delete Student from Database or wherever we are storing.
        return Response.status(202).entity("Student deleted").build();
    }
}
