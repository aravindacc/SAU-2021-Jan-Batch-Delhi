import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeDBService {

  //list acts as database
  employeeList = [{id : "1", name : "Satyam", age : 21, dob : "1998-01-08"}];
  constructor() { }

  
  
  //service functions for crud operations
  getEmployees(){
    return this.employeeList;
  }

  addEmployee(employee){
    this.employeeList.push(employee);
  }

  deleteEmploye(index){
    this.employeeList.splice(index, 1);
  }

  getEmployeeAtIndex(index){
    return this.employeeList[index];
  }

  saveEditedEmployee(index, employee){
    this.employeeList[index] = employee;
  }
}
