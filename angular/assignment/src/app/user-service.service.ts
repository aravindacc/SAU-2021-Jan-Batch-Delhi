import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService  {



  /*
  Note: If you wanna run on session storage
  uncomment the lines above the http calls
  and it should work fine.
  */


  userData:any=[];

  userDataBS=new BehaviorSubject({});
  obs=this.userDataBS.asObservable();

  constructor( private httpClient:HttpClient) { }

  async sendData(){
    // this.userDataBS.next(this.userData);
    await this.httpClient.get('http://localhost:3000/users').subscribe(resp =>{
      this.userData=resp;
      this.userDataBS.next(this.userData);
    });

  }
  addData(newUser)
  {
    // this.userData.push(newUser);
    this.httpClient.post('http://localhost:3000/users',newUser).subscribe(resp=>
      {
      });
  }

  deleteUser(currentUser)
  {
    // this.userData.splice(this.userData.indexOf(currentUser),1);
    this.httpClient.delete('http://localhost:3000/users/'+currentUser.id).subscribe(resp=>{
    });
  }

   updateUser(oldDetails,newDetails)
  {
    // this.userData[this.userData.indexOf(oldDetails)]=newDetails;
      this.httpClient.put('http://localhost:3000/users/'+oldDetails.id+'/',newDetails).subscribe(resp=>{
      this.sendData();
    });
  }
}
