import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import {DataService} from './data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'assignment';
  employeeForm : FormGroup;

  constructor(
    private employeeService : DataService,
    private fb : FormBuilder
  ){}

  ngOnInit(){
    this.employeeForm = this.fb.group({
      name : new FormControl('',[Validators.required, Validators.minLength(3)]),
      id : new FormControl('', Validators.required),
      age : new FormControl('', Validators.required),
      dob : new FormControl('', Validators.required)
    });
  }

  onSubmit(): void {
    //console.log(this.employeeService.getEmployees());
    var nameStr = this.employeeForm.get('name').value;
    var idStr = this.employeeForm.get('id').value;
    var ageNumber = this.employeeForm.get('age').value;
    var dobStr = this.employeeForm.get('dob').value;
    var employee = {name : nameStr, id : idStr, age : ageNumber, dob : dobStr};
    this.employeeService.addEmployee(employee);
  }
}
