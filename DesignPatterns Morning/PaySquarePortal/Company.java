package PaySquarePortal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Company {
	public static void main(String args[]) {
		List<Employee> empList = new ArrayList<>();
		EmployeeFactory factory = new EmployeeFactory();
		empList.add(factory.createEmployee(1, "ABC", "Fresher", "SMS"));
		empList.add(factory.createEmployee(2, "XYZ", "Developer", "MAIL"));
		empList.add(factory.createEmployee(3, "MNO", "Admin", "SMS"));
		empList.add(factory.createEmployee(4, "DEF", "Developer", "MAIL"));
		empList.add(factory.createEmployee(5, "PQR", "Developer", "SMS"));

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime today = LocalDateTime.now();

		if (today.getDayOfMonth() == 15 && today.getHour() == 15 && today.getMinute() == 0 && today.getSecond() == 0) {
			for (Employee emp : empList) {
				emp.sendNotification();
			}
		}

	}
}
