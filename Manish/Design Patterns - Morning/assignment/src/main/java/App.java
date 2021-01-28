import model.EmployeePost;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import portal.EmployeeFactory;
import portal.NotificationJob;
import portal.PaySquarePortal;

import java.util.Date;

public class App {
    public static void main(String[] args) throws SchedulerException {

        PaySquarePortal.getInstance().addEmployee(EmployeeFactory.getInstance().createEmploy("Abc", EmployeePost.INTERN));
        PaySquarePortal.getInstance().addEmployee(EmployeeFactory.getInstance().createEmploy("Def", EmployeePost.SOFTWARE_DEVELOPER));
        PaySquarePortal.getInstance().addEmployee(EmployeeFactory.getInstance().createEmploy("Ghi", EmployeePost.MANAGER));
        PaySquarePortal.getInstance().addEmployee(EmployeeFactory.getInstance().createEmploy("Jkl", EmployeePost.DIRECTOR));
        PaySquarePortal.getInstance().addEmployee(EmployeeFactory.getInstance().createEmploy("Mno", EmployeePost.CEO));


        JobDetail job = JobBuilder.newJob(NotificationJob.class).withIdentity("notification-job", "app").build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("cronTrigger", "app")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 16 15 * ? *")) // send notification monthly at 15
//                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ? *")) //  send notification every 5 seconds
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
