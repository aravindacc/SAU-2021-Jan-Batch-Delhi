import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { BASE_URL } from 'src/app/constants/baseurl';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.scss']
})
export class EmployeeDetailsComponent implements OnInit {

  user: any=[] ;
  specificUser: any = [];
  username='';
  showTable=false;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get(BASE_URL + '/emp').subscribe((data)=>{
      this.user =  data ;
    });
  }
  show= (id: any,username:any) => {
    this.showTable=true;
    this.specificUser=[];
    this.username=username;
    this.http.get(BASE_URL + '/emp/'+id).subscribe((data)=>{
       this.specificUser= data ;
     });
}

}
