import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl, Validators} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';
import {EmpservService} from '../empserv.service';
@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.scss']
})
export class UpdateEmployeeComponent implements OnInit {

  constructor(
    private router: ActivatedRoute,
    private empdata : EmpservService
  ) { }
  alert:boolean=false;
  editemp=new FormGroup(
    {
        first_name : new FormControl('',[Validators.required,Validators.minLength(3),Validators.pattern('[a-zA-Z]*')]),
        last_name: new FormControl('',[Validators.required,Validators.minLength(3),Validators.pattern('[a-zA-Z ]*')]),
        age : new FormControl('',[Validators.required,Validators.pattern('[1-9][0-9]*')]),
        DOB : new FormControl('',[Validators.required])
    }
  )
  ngOnInit(): void {
    console.log(this.router.snapshot.params.id);
    this.empdata.getCurrentEmployee(this.router.snapshot.params.id).subscribe((result)=>{
           // console.log(result);
           this.editemp=new FormGroup(
            {
                first_name : new FormControl(result["first_name"]),
                last_name: new FormControl(result["last_name"]),
                age : new FormControl(result["age"]),
                DOB : new FormControl(result["DOB"])
            })
    });

  }

  updateEmployeeData()
  {
    this.empdata.updateEmployeeData(this.router.snapshot.params.id,this.editemp.value).subscribe((result)=>{
      console.log(result);
      this.alert=true;

    });
    this.editemp.reset({});
  }
  closeAlert()
  {
    this.alert=false;
  }

}
