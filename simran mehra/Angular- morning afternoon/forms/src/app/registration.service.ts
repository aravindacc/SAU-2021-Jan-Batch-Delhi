import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  private users = [new User('Mickey', '1001', '1997-05-12', 25),
  new User('Arjun', '1002', '1996-09-12', 24)];
  constructor(private _http: HttpClient) { }

  getUsers() {
    return [...this.users]
  }
  getUser(id: string) {
    return this.users.find(item => item.EmployeeID === id);
  }

  addUser(user: User) {
    this.users.push(user);
  }

  updateUser(user: User) {
    const index = this.users.findIndex(item => item.EmployeeID === user.EmployeeID)
    this.users[index] = user;
  }
}
