import { Component } from '@angular/core';
import {Router} from '@angular/router'
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],

})
export class AppComponent {
  parentEmp={};
  title = 'My-assignment';
  today=Date.now();
  constructor(private router: Router){}
  navigateToAddUsers(){
    this.router.navigate(['AddUsers'])
  }
  navigateToDeleteUsers(){
    this.router.navigate(['DeleteUsers'])
  }

  navigateToShowAllUsers(){
    this.router.navigate(['ShowAllUsers'])
  }
  navigateToEditUsers(){
    this.router.navigate(['EditUsers'])
  }
  emitAlert(emp:any){
      emp=JSON.parse(emp);
       this.parentEmp=emp;
  }
}
