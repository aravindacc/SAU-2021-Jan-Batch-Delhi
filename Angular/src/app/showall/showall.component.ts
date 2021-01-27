import { EmplsService } from './../service/empls.service';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-showall',
  templateUrl: './showall.component.html',
  styleUrls: ['./showall.component.css']
})
export class ShowallComponent implements OnInit {

  constructor(private empService:EmplsService,private router:Router) { }
  list=[];


  ngOnInit(): void {
    this.list=this.empService.showall();
  }

  listFilter(id){
    this.list=this.list.filter((emp)=>{
      if(emp.empId!==id){
        return true;
      }
    })
  }

}
