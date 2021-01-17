import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/model/user';
import { UserListService } from 'src/app/service/user-list.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css'],
})
export class AddUserComponent implements OnInit {
  userToEdit?: User;

  userFG = new FormGroup({
    id: new FormControl('', [Validators.required, Validators.minLength(1)]),
    name: new FormControl('', [
      Validators.required,
      Validators.minLength(4),
      Validators.maxLength(50),
    ]),
    username: new FormControl('', [
      Validators.required,
      Validators.minLength(1),
      Validators.maxLength(30),
    ]),
    email: new FormControl('', [Validators.required, Validators.email]),
  });

  constructor(private userListSvc: UserListService) {}

  ngOnInit(): void {
    this.userListSvc.getEditUser().subscribe((user) => {
      this.userToEdit = user;
      this.userFG.setValue({
        id: user.id,
        name: user.name,
        username: user.username,
        email: user.email,
      });
    });
  }

  addUser() {
    // if form values not valid
    if (!this.userFG.valid) {
      alert('Credentials not valid...');
      return;
    }

    // update to server  (will update if id aleady exists else adding new user )
    this.userListSvc.addUser(this.userFG.value)?.subscribe(() => {
      console.log('User added to server');
    });
    alert("User added/updated")

    // make form blank
    console.log(this.userFG.value);
    this.userFG.setValue({
      id: NaN,
      name: '',
      username: '',
      email: '',
    });
  }
}
