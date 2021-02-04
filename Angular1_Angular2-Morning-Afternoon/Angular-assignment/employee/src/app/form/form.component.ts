import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { RegisterEmployeeService } from '../register-employee.service';
import { FormBuilder } from "@angular/forms";
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {
  

  constructor(private fb:FormBuilder, private _registerEmployeeService:RegisterEmployeeService,
    private _http:HttpClient,private router:Router) { }

// Creating form interface

    registrationForm = this.fb.group({
      Name:['',[Validators.required]],
      EmployeeId:['',[Validators.required]],
     
      DateOfBirth :['',[Validators.required]],
   
      State :['',[Validators.required]],
      City :['',[Validators.required]],
      Zip :['',[Validators.required]]
    });

  ngOnInit(): void {
  }

  // Adding the employee detail
  onSubmit(){

    console.log(this.registrationForm.value);
    this._http.post("http://localhost:5500/employee", this.registrationForm.value).subscribe((Response) => {
      console.log(Response);
      alert("Information Saved Successfully");

      // redirecting to employee detail page
      this.router.navigate(['/home']);
    })
  }
}



