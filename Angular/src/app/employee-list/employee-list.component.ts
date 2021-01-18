
import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { DataService } from '../data.service';


@Component({
  selector: 'app-employee-list-component',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {

  public employeeList = [{}];
  constructor(
    private employeeService : DataService,
    private _router : Router
  ) { }

  ngOnInit(): void {
    this.employeeList = this.employeeService.getEmployees();
  }

  deleteItem(index){
    console.log(this.employeeService.getEmployeeAtIndex(index));
    this.employeeService.deleteEmploye(index);
  }

  redirectToEdit(index){
    var employeeObject2 = this.employeeService.getEmployeeAtIndex(index);
    this._router.navigate(['/edit-employee', employeeObject2.name, employeeObject2.id, employeeObject2.age, employeeObject2.dob, index]);
  }
}
