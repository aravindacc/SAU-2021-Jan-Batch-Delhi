package org.jatin.Controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jatin.Service.UserService;
import org.jatin.bean.User;

@Path(value="users")
public class userController {
	
	UserService userService=new UserService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers()
	{
		return userService.getAllUsers();
	}
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getUserByID(@PathParam("id") int id)
	{
		User user=userService.getUserById(id);
		if(user==null)
			return "User Didnt exist";
		return user;
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public User addUser(User user)
	{
		return userService.addUser(user);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(User user)
	{
		return userService.updateUser(user);
	}
	
	
	@DELETE
	@Path("{id}")
	public String deleteUser(@PathParam("id") int id)
	{
		return userService.deleteUser(id)?"Successfully Deleted":"record Didnt exist";
	}
}
