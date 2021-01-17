import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeDBService {

  employeeList = [
    {id : "101", name : "Utkarsh", age : 21, dob : "1999-01-27"}
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
