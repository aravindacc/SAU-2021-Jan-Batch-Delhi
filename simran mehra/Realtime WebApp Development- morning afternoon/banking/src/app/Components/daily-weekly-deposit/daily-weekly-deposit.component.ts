import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { BASE_URL } from 'src/app/constants/baseurl';

@Component({
  selector: 'app-daily-weekly-deposit',
  templateUrl: './daily-weekly-deposit.component.html',
  styleUrls: ['./daily-weekly-deposit.component.scss']
})
export class DailyWeeklyDepositComponent implements OnInit {

  user: any=[] ;

  constructor(
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.http.get(BASE_URL + '/emp/daily').subscribe((data)=>{
        this.user =  data ;
      });
  }


}
