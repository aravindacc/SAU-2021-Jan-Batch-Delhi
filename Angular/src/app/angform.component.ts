import { EmplsService } from './../service/empls.service';
//import { EmpService } from './../service/emp.service';

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {FormControl, FormGroup, FormGroupDirective} from '@angular/forms';

@Component({
  selector: 'app-angform',
  templateUrl: './angform.component.html',
  styleUrls: ['./angform.component.css']
})
export class AngformComponent implements OnInit {
 

  
   EmployeeDetails= new FormGroup({
     
     EmployeeName: new FormControl(''),
     EmployeeID: new FormControl(''),
     EmployeeDOB: new FormControl(''),
     EmployeeAge: new FormControl('')

   });
   
   
  constructor(private empService:EmplsService) { }

  ngOnInit(): void {
  }
  onSubmit(){
   // console.log(this.EmployeeDetails.value);
   var obj={
    EmployeeName:this.EmployeeDetails.get("EmployeeName").value,
    EmployeeID:this.EmployeeDetails.get("EmployeeID").value,
    EmployeeDOB:this.EmployeeDetails.get("EmployeeDOB").value,
    EmployeeAge:this.EmployeeDetails.get("EmployeeAge").value,
  }
  var ans=this.empService.addEmployee(obj);

    return true;

  }

}