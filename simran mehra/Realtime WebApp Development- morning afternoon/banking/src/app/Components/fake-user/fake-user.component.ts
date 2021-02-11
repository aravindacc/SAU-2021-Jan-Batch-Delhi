import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fake-user',
  templateUrl: './fake-user.component.html',
  styleUrls: ['./fake-user.component.scss']
})
export class FakeUserComponent implements OnInit {

  user: any=[] ;

  constructor(
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.http.get('/fake').subscribe((data)=>{
        this.user =  data ;
      });
  }

}
