import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  employeeList = [
    {id : "786", name : "Muskan", age : 21, dob : "1999-10-04"}
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
