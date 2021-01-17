import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { UserListService } from 'src/app/service/user-list.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-user',
  templateUrl: './all-user.component.html',
  styleUrls: ['./all-user.component.css'],
})
export class AllUserComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UserListService, private router: Router) {}

  //on intialization load all userlist from server
  ngOnInit(): void {
    this.getAllUser();
  }

  // get all user from server
  getAllUser() {
    this.userService.getAllUser().subscribe((allUsers) => {
      this.users = allUsers;
    });
  }

  // delete from UI  and server
  deleteUser(id: number) {
    this.userService.deleteUser(id).subscribe(() => {
      console.log('deleted from server');
    });
  }

  // edit user
  editUser(user: User) {
    this.userService.setEditUser(user);
    this.router.navigateByUrl('/add-user');
    console.log("Updating user on server"); 
  }
}
