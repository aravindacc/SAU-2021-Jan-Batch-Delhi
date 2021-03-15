package org.jatin.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jatin.bean.User;

public class UserService {
	
	static HashMap<Integer,User> users=new HashMap<>();
	static int currentId=0;
	public UserService(){
		super();
		if(users.isEmpty())
		{
			users.put(++currentId,new User(currentId,"Jatin",23));
			users.put(++currentId,new User(currentId,"Himani",28));
			users.put(++currentId,new User(currentId,"Vikash",24));
			users.put(++currentId,new User(currentId,"Nipun",23));
		}
	}
	
	
	public List<User> getAllUsers()
	{
		List<User> allUsers= new ArrayList<>(users.values());
		return allUsers;
	}
	
	public User getUserById(int id)
	{
		if(!users.containsKey(id))
			return null;
		return users.get(id);
	}
	
	
	public User addUser(User user)
	{
		user.setId(++currentId);
		users.put(currentId, user);
		return users.get(currentId);
	}
	
	public User updateUser(User user)
	{
		users.put(user.getId(), user);
		return user;
	}

	public boolean deleteUser(int id)
	{
		if(users.containsKey(id))
			return false;
		users.remove(id);
		return true;
	}
}
