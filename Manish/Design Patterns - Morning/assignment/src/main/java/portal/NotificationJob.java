package portal;

import model.Employee;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class NotificationJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        PaySquarePortal portal =  PaySquarePortal.getInstance();

        for (Employee emp : portal.getAllEmployee()) {
            emp.setSalaryPaid(true); // paid the salary
        }

        System.out.println("\n===============================\n");

    }
}
