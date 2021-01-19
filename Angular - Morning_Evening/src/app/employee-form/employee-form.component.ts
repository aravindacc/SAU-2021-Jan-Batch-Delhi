import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.scss']
})
export class EmployeeFormComponent implements OnInit {

  name = "";
  id = '';
  age;
  dob;
  indexToBeEdited;

  employeeObj;
  constructor(
    private employeeService : DataService,
    private _router : ActivatedRoute,
    private _routerGoBack : Router
  ) {
  }

  ngOnInit(): void {
    this.name = this._router.snapshot.params['name'];
    this.age = this._router.snapshot.params['age'];
    this.id = this._router.snapshot.params['id'];
    this.dob = this._router.snapshot.params['dob'];
    this.indexToBeEdited = this._router.snapshot.params['index'];
  }

  saveItem(){
    var employeeObject = {name : this.name, id : this.id, age : this.age, dob : this.dob};
    this.employeeService.saveEditedEmployee(this.indexToBeEdited, employeeObject);
    this._routerGoBack.navigate(['/route-list']);
  }



}
