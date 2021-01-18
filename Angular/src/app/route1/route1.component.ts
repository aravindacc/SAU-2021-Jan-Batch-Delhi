
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-route1',
  templateUrl: './route1.component.html',
  styleUrls: ['./route1.component.css']
})
export class Route1Component implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  abc(){
    console.log("HI");
    this.router.navigate(['route2']);
  }
}
