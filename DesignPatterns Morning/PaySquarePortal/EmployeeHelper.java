package PaySquarePortal;

public class EmployeeHelper {
	public static Employee createEmployee(int id, String name, String designation, String notificationMode) {

		switch (designation) {
			case "Fresher":
				return new Fresher(id, name, notificationMode);
			case "Developer":
				return new Developer(id, name, notificationMode);
			case "Admin":
				return new Admin(id, name, notificationMode);
			default:
				return null;
		}
	}
}
