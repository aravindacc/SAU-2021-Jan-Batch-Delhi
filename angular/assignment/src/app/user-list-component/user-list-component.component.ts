import { Component, Input, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-user-list-component',
  templateUrl: './user-list-component.component.html',
  styleUrls: ['./user-list-component.component.scss']
})
export class UserListComponentComponent implements OnInit {

  showEditDetails:boolean=false;

  @Input()
  currentUser;

  constructor(private userService:UserServiceService) { }

  ngOnInit(): void {
  }
  deleteCurrent()
  {
    this.userService.deleteUser(this.currentUser)
  }

  editCurrent()
  {
    this.showEditDetails=true;
  }

  hideUpdateComponent(flag)
  {
    this.showEditDetails=false;
  }
}
