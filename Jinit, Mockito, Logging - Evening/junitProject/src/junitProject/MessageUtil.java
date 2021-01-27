package junitProject;

public class MessageUtil {
	public String message;
	public MessageUtil(String message)
	{
		this.message=message;
	}
	public String printMessage(String message) {
		message=message+"print";
		System.out.println("Message from class "+message);
		return message;
	}

}
