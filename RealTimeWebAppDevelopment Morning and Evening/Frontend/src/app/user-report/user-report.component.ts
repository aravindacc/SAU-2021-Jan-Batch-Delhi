import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-user-report',
  templateUrl: './user-report.component.html',
  styleUrls: ['./user-report.component.scss']
})
export class UserReportComponent implements OnInit {

  user: any=[] ;
  specific: any = [];
  username='';
  showTable=false;

  constructor(
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.http.get('http://localhost:8081/user').subscribe((data)=>{
        this.user =  data ;
        console.log(data);
      });
  }

  show= (id: any,username:any) => {
      this.showTable=true;
      this.specific=[];
      this.username=username;
      this.http.get('http://localhost:8081/user/'+id).subscribe((data)=>{
         this.specific= data ;
         console.log(this.specific);
       });
  }

}
