import { User } from './../user.model';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { nameValidator } from '../shared/employee-name.validator';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  submitted = false;
  registrationForm: any;
  userId: any;
  get EmployeeName() {
    return this.registrationForm.controls.EmployeeName;
  }
  get EmployeeID() {
    return this.registrationForm.controls.EmployeeID;
  }
  get EmployeeDOB() {
    return this.registrationForm.controls.EmployeeDOB;
  }
  get EmployeeAge() {
    return this.registrationForm.controls.EmployeeAge;
  }
  constructor(private fb: FormBuilder, private _registrationService: RegistrationService,
    private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.userId = this.route.snapshot.params.id;
    if (this.userId) {
      this.loadEditData(this.userId)
    }
    else {
      this.registrationForm = this.fb.group({
        EmployeeName: ['', [Validators.required, Validators.minLength(3), nameValidator]],
        EmployeeID: ['', [Validators.required]],
        EmployeeDOB: ['', [Validators.required]],
        EmployeeAge: ['', [Validators.required]]
      });
    }
  }
  // loadApiData() {
  //   this.registrationForm.setValue({
  //     EmployeeName: 'Abc',
  //     EmployeeID: '21008',
  //     EmployeeDOB: '2020-01-16',
  //     EmployeeAge: '1'
  //   });
  // }

  loadEditData(userId: string) {
    const editedUser = this._registrationService.getUser(userId);
    this.registrationForm = this.fb.group({
      EmployeeName: [editedUser?.EmployeeName, [Validators.required, Validators.minLength(3), nameValidator]],
      EmployeeID: [editedUser?.EmployeeID, [Validators.required]],
      EmployeeDOB: [editedUser?.EmployeeDOB],
      EmployeeAge: [editedUser?.EmployeeAge]
    });
    this.registrationForm.get('EmployeeID').disabled;
  }

  onSubmit() {
    this.submitted = true;
    const submittedData = this.registrationForm.value;
    if (this.userId) {
      this._registrationService.updateUser(submittedData)
    }
    else {
      this._registrationService.addUser(submittedData)
    }
    this.router.navigate(['/user']);
  }
}
