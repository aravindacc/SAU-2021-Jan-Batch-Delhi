import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import {EmployeeDBService} from './employeedatabase.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'assignment';
  employeeForm : FormGroup;

  onSubmit(): void {
    var username = this.employeeForm.get('name').value;
    var userid = this.employeeForm.get('id').value;
    var userage = this.employeeForm.get('age').value;
    var userdob = this.employeeForm.get('dob').value;
    var employee = {name : username, id : userid, age : userage, dob : userdob};
    this.employeeService.addEmployee(employee);
  }

  constructor(
    private employeeService : EmployeeDBService,
    private fb : FormBuilder
  ){}

  ngOnInit(){
    this.employeeForm = this.fb.group({
      name : new FormControl(''),
      id : new FormControl(''),
      age : new FormControl(''),
      dob : new FormControl('')
    });
  }
}
