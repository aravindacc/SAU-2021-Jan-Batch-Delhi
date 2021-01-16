import { query } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { EmployeeDBService } from '../employee-db.service';


@Component({
  selector: 'app-employee-list-component',
  templateUrl: './employee-list-component.component.html',
  styleUrls: ['./employee-list-component.component.scss']
})
export class EmployeeListComponentComponent implements OnInit {

  public employeeList = [];
  constructor(
    private employeeService : EmployeeDBService,
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
