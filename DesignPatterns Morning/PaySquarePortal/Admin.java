package PaySquarePortal;

public class Admin extends Employee {
	public Admin(int id, String name, String notificationMode) {
		setId(id);
		setName(name);
		setNotificationMode(notificationMode);
		setDesignation("Admin");
		setSalary(200000);
	}
}
