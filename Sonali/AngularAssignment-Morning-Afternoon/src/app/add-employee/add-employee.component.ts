import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl, Validators} from '@angular/forms';
import {EmpservService} from '../empserv.service'
@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.scss']
})
export class AddEmployeeComponent implements OnInit {

  constructor(
    private empdata : EmpservService
  ) { }
  alert : boolean =false;
  addemp=new FormGroup(
    {
        first_name : new FormControl('',[Validators.required,Validators.minLength(3),Validators.pattern('[a-zA-Z]*')]),
        last_name: new FormControl('',[Validators.required,Validators.minLength(3),Validators.pattern('[a-zA-Z ]*')]),
        age : new FormControl('',[Validators.required,Validators.pattern('[1-9][0-9]*')]),
        DOB : new FormControl('',[Validators.required])
    }
  )
  ngOnInit(): void {
  }
  addEmployeeData()
  {
    //console.log(this.addemp.value);
    this.empdata.saveEmployeeData(this.addemp.value).subscribe((result)=>{
      console.warn(result);
      this.alert=true;
    });
    this.addemp.reset({});

  }
  closeAlert()
  {
    this.alert=false;
  }
}
