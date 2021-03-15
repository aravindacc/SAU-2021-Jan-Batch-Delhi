package com.jatin;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.jar.Attributes;


public class NotificationJob implements Job {

    ArrayList<Employee> employees=new ArrayList<>();

    public NotificationJob() throws IOException {

        EmployeeFactory employeeFactory=new EmployeeFactory();
//
//
//        Employee employee2=employeeFactory.getEmployeeObject("Intern");
//        employee2.setAttributes("Himani",2,"Email");
//        employees.add(employee2);
//
//        Employee employee3=employeeFactory.getEmployeeObject("SDE");
//        employee3.setAttributes("Nipun",3,"SMS");
//        employees.add(employee3);
//
//        Employee employee4=employeeFactory.getEmployeeObject("Manager");
//        employee4.setAttributes("Viaksh",4,"Email");
//        employees.add(employee4);
//
//        Employee employee5=employeeFactory.getEmployeeObject("Intern");
//        employee5.setAttributes("Kanika",5,"Push");
//        employees.add(employee5);
        int id=1;
        FileInputStream inputStream = new FileInputStream(new File("src/main/resources/Book1.xlsx"));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            ArrayList<String> attributes=new ArrayList<>();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                attributes.add(cell.getStringCellValue());
            }

            Employee employee=employeeFactory.getEmployeeObject(attributes.get(0));
            employee.setAttributes(attributes.get(1),id++,attributes.get(2));
            employees.add(employee);
        }
        workbook.close();
        inputStream.close();
}


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        for(Employee e:employees)
        {
            e.setSalaryCredited(true);
        }
    }
}
