import { Component } from '@angular/core';
import { CommonService } from './common.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngPro';
  allUser: any;
  isEdit = false;

  userObj={
    name:'',
    Eid:'',
    age:'',
    dob:'',
    id:''
  }

  constructor(private commonService:CommonService){}

  ngOnInit(){
    this.getLatestUser()
  }
  addUser(formObj: any){
    // console.log(formObj)
    this.commonService.createUser(formObj).subscribe((response)=>{
      this.getLatestUser();   
    })
  }
  getLatestUser(){
    this.commonService.getAllUser().subscribe((response)=>{
      this.allUser = response;
      // console.log(this.allUser);  
    })
  }
  editUser(user:any){
    this.isEdit=true;
    this.userObj=user;
  }
  deleteUser(user:any){
    // console.log(user)
     this.commonService.deleteUser(user).subscribe(()=>{
       this.getLatestUser();
     })
  }
  updateUser(){
    this.isEdit = !this.isEdit;
    this.commonService.updateUser(this.userObj).subscribe(()=>{
      this.getLatestUser();
    })
  }
}
