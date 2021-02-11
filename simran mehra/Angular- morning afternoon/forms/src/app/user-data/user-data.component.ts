import { RegistrationService } from './../registration.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user.model';

@Component({
  selector: 'app-user-data',
  templateUrl: './user-data.component.html',
  styleUrls: ['./user-data.component.scss']
})
export class UserDataComponent implements OnInit {
  registerData: Array<User> = [];

  constructor(private registrationService: RegistrationService, private router: Router) { }

  ngOnInit(): void {
    this.registerData = this.registrationService.getUsers();
  }
  onEdit(user: User) {
    this.router.navigate(['/register/', user.EmployeeID]);
  }
  onDelete(user: User) {
    this.registerData = this.registerData.filter(item => item.EmployeeID !== user.EmployeeID);
  }
  addEmployee() {
    this.router.navigate(['/register/']);
  }
}
