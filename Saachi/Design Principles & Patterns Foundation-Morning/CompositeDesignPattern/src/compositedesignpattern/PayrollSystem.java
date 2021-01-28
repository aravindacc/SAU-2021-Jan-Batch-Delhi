package compositedesignpattern;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.concurrent.*;

public class PayrollSystem {

    public static void main(String[] args) {

        ArrayList<Employee> payrollList = new ArrayList<>();

        Employee ep1, ep2, ep3, ep4, ep5;

        ep1 = new Manager("Saachi", "m101", 100000,"SMS");
        ep2 = new Manager("Aman", "m102", 100000, "SMS");
        ep3 = new ProfessionalDeveloper( "d103", 1200, "SMS","JavaDev");
        ep4 = new ProfessionalDeveloper( "d104", 1000, "E-mail","AngularDev");
        ep5 = new InternDeveloper( "i103", 500,"E-mail" ,"ReactDev");

        payrollList.add(ep1);
        payrollList.add(ep2);
        payrollList.add(ep3);
        payrollList.add(ep4);
        payrollList.add(ep5);

        //Add hours for Managers and HourlyEmployees

        for (Employee employee : payrollList) {

            if (employee instanceof InternDeveloper) {
                ((InternDeveloper) employee).addHours(TimeCard.Day.MONDAY, 6);
                ((InternDeveloper) employee).addHours(TimeCard.Day.TUESDAY, 8);
                ((InternDeveloper) employee).addHours(TimeCard.Day.WEDNESDAY, 9);
                ((InternDeveloper) employee).addHours(TimeCard.Day.THURSDAY, 10);
                ((InternDeveloper) employee).addHours(TimeCard.Day.FRIDAY, 8);
            }

            if (employee instanceof ProfessionalDeveloper) {
                ((ProfessionalDeveloper) employee).addHours(TimeCard.Day.MONDAY, 6);
                ((ProfessionalDeveloper) employee).addHours(TimeCard.Day.TUESDAY, 8);
                ((ProfessionalDeveloper) employee).addHours(TimeCard.Day.WEDNESDAY, 9);
                ((ProfessionalDeveloper) employee).addHours(TimeCard.Day.THURSDAY, 10);
                ((ProfessionalDeveloper) employee).addHours(TimeCard.Day.FRIDAY, 8);
            }

            if (employee instanceof Manager) {
                ((Manager) employee).setBonus(50);
            }
        }

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        long delayTime;
        final Long initialDelay = LocalDateTime.now().until(LocalDate.now().plusDays(1).atTime(15, 00), ChronoUnit.MINUTES);

        if (initialDelay > TimeUnit.DAYS.toMinutes(15)) {
            delayTime = LocalDateTime.now().until(LocalDate.now().atTime(15, 00), ChronoUnit.MINUTES);
        } else {
            delayTime = initialDelay;
        }

        Runnable task = () -> {
            for (Employee e : payrollList) {
                e.computeSalary();
                e.sendSalaryNotification(e.getNotifyMode());
                e.printDetails();
                System.out.println("\n");
            }
        };

        scheduler.scheduleAtFixedRate(task, delayTime, 15, TimeUnit.DAYS);
    }
}
