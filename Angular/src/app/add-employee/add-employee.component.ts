import { EmpServiceService } from './../Service/emp-service.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormGroupDirective, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  id:any;
  Title:any;
  disableUpdate:Boolean=false;
  tmp:any=null;
  constructor(private route:ActivatedRoute,private empService:EmpServiceService) { }

  createForm:FormGroup;
  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get('id');

    //this.id1=this.route.snapshot.paramMap.get('id');
    if(this.id==0){
      this.disableUpdate=true;
      this.Title="Add"
      this.createForm=new FormGroup({
        'empId' : new FormControl(null,[Validators.required,Validators.pattern("^[a-zA-Z0-9]*$"),Validators.minLength(3)]),
        'empAge': new FormControl(null,[Validators.required,Validators.max(100),Validators.min(20)]),
        'empName' : new FormControl(null,[Validators.required,Validators.pattern("^[a-zA-Z0-9 ]*$"),Validators.minLength(3)]),
        'empDob' : new FormControl(null,[Validators.required])
     });
    }
    else{
      this.disableUpdate=false;
      this.Title="Edit";
      this.createForm=new FormGroup({
        'empId' : new FormControl(null,[Validators.required,Validators.pattern("^[a-zA-Z0-9 ]*$"),Validators.minLength(3)]),
        'empAge': new FormControl(null,[Validators.required]),
        'empName' : new FormControl(null,[Validators.required,Validators.pattern("^[a-zA-Z0-9, ]*$"),Validators.minLength(5)]),
        'empDob' : new FormControl(null,[Validators.required])
     });

          this.tmp=this.empService.getEmployeeById(this.id);
          console.log(this.tmp);
          if(this.tmp===null){
            alert("No such Employee , exists with this ID");
          }
          else{
          this.createForm.get('empId').setValue(this.tmp.empId);
          this.createForm.get('empAge').setValue(this.tmp.empAge);
          this.createForm.get('empName').setValue(this.tmp.empName);
          this.createForm.get('empDob').setValue(this.tmp.empDob);
         }

    }
  }

  onSubmit(formData:FormGroupDirective):Boolean{
    // formData.reset();
    var obj={
      empId:this.createForm.get("empId").value,
      empName:this.createForm.get("empName").value,
      empAge:this.createForm.get("empAge").value,
      empDob:this.createForm.get("empDob").value,
    }
    var ans=this.empService.addEmployee(obj);

    if(ans===true)
    {
    alert("Employee Added Successfully");
    formData.reset();
    }
    return true;
  }

  onEdit(formData:FormGroupDirective):Boolean{
    var obj={
      empId:this.createForm.get("empId").value,
      empName:this.createForm.get("empName").value,
      empAge:this.createForm.get("empAge").value,
      empDob:this.createForm.get("empDob").value,
    }
    var ans=this.empService.editEmployeeDetail(obj);
    if(ans===true){
    alert("Employee Edited Successfully");
    formData.reset();
    }
    return true;
  }

}
