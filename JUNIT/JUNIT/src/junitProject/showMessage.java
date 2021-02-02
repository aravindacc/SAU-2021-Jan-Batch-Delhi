package junitProject;

public class showMessage {
	public String message;
	public showMessage(String message)
	{
		this.message=message;
	}
	public String printMessage(String message) {
		message=message+"show";
		System.out.println("Message  "+message);
		return message;
	}

}
