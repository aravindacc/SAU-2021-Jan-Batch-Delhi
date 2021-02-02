package compositedesignpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollSystem {

    public static void main(String[] args) {

        ArrayList<Employee> payrollList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();

        Employee ep1, ep2, ep3, ep4, ep5;

        ep1 = new Manager("saachi", "m101", 100000);
        ep2 = new Manager("aman", "m102", 100000);
        ep3 = new ProfessionalDeveloper( "d103", 1200, "javadev");
        ep4 = new ProfessionalDeveloper( "d103", 1000, "angulardev");
        ep5 = new InternDeveloper( "i103", 500, "reactdev");

        payrollList.add(ep1);
        payrollList.add(ep2);
        payrollList.add(ep3);
        payrollList.add(ep4);
        payrollList.add(ep5);

        //Add hours for Managers and HourlyEmployees
        int size = TimeCard.Day.values().length;

        for(int x = 0; x < payrollList.size(); x++)
        {

                if(payrollList.get(x) instanceof InternDeveloper)
                {
                    ((InternDeveloper)payrollList.get(x)).addHours(TimeCard.Day.MONDAY, 6);
                    ((InternDeveloper)payrollList.get(x)).addHours(TimeCard.Day.TUESDAY, 8);
                    ((InternDeveloper)payrollList.get(x)).addHours(TimeCard.Day.WEDNESDAY, 9);
                    ((InternDeveloper)payrollList.get(x)).addHours(TimeCard.Day.THURSDAY, 10);
                    ((InternDeveloper)payrollList.get(x)).addHours(TimeCard.Day.FRIDAY, 8);
                }

            if(payrollList.get(x) instanceof ProfessionalDeveloper)
            {
                ((ProfessionalDeveloper)payrollList.get(x)).addHours(TimeCard.Day.MONDAY, 6);
                ((ProfessionalDeveloper)payrollList.get(x)).addHours(TimeCard.Day.TUESDAY, 8);
                ((ProfessionalDeveloper)payrollList.get(x)).addHours(TimeCard.Day.WEDNESDAY, 9);
                ((ProfessionalDeveloper)payrollList.get(x)).addHours(TimeCard.Day.THURSDAY, 10);
                ((ProfessionalDeveloper)payrollList.get(x)).addHours(TimeCard.Day.FRIDAY, 8);
            }

            if(payrollList.get(x) instanceof Manager)
            {
                ((Manager)payrollList.get(x)).setBonus(50);
            }
        }

        //Scanner input = new Scanner(System.in);


        for(Employee e: payrollList){
            e.computeSalary();
            //type either "E-mail" or "SMS"
//            System.out.print("Enter notifyMode:");
//            String mode = input.nextLine();
            e.sendSalaryNotification("SMS");
            e.printDetails();
            System.out.println("\n");
        }
    }
}
