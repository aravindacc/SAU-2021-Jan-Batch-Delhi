import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService  {

  userData:any=[];

  userDataBS=new BehaviorSubject({});
  obs=this.userDataBS.asObservable();

  constructor( private httpClient:HttpClient) { }

  sendData(){
    this.userDataBS.next(this.userData);
  }
  addData(newUser)
  {
    this.userData.push(newUser);
  }

  deleteUser(currentUser)
  {
    this.userData.splice(this.userData.indexOf(currentUser),1);
  }

  updateUser(oldDetails,newDetails)
  {
    console.log(newDetails);
    this.userData[this.userData.indexOf(oldDetails)]=newDetails;
  }
}
