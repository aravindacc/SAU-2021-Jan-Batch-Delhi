import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeDBService {

  employeeList = [
    {id : "1", name : "Hemant", age : 22, dob : "1998-01-15"}
  ];
  constructor() { }

  getEmployees(){
    return this.employeeList;
  }

  getEmployeeAtIndex(index){
    return this.employeeList[index];
  }

  addEmployee(employee){
    this.employeeList.push(employee);
  }

  deleteEmploye(index){
    this.employeeList.splice(index, 1);
  }

  saveEditedEmployee(index, employee){
    this.employeeList[index] = employee;
  }
}
