import { getLocaleDateFormat } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.scss']
})
export class ViewUserComponent implements OnInit {

  userList;

  constructor(private userService:UserServiceService) { }

  ngOnInit(): void {
    this.getData()
  }

  getData()
  {
    this.userService.sendData();
    this.userService.obs.subscribe(response =>{
      this.userList=response;
    })
  }

}
