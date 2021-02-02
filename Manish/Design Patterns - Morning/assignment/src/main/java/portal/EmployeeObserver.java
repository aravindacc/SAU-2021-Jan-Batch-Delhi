package portal;

import model.Employee;
import model.Notification;
import model.NotificationType;
import org.w3c.dom.Node;

import java.util.Observable;
import java.util.Observer;

public class EmployeeObserver implements Observer {

    private Employee employee;

    public EmployeeObserver(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void update(Observable observable, Object o) {
        NotificationBuilder notificationBuilder = new NotificationBuilder();
        Notification notification = notificationBuilder.createNotification(NotificationType.SALARY,  "Congrats "+employee.getEmployeeName()+" You salary of amount "+employee.getTotalSalary()+" has be deposited");
        NotificationService.getInstance().sendNotification(notification);
    }
}
