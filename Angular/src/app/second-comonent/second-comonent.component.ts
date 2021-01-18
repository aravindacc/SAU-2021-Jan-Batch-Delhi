import { Component, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-second-comonent',
  templateUrl: './second-comonent.component.html',
  styleUrls: ['./second-comonent.component.css']
})
export class SecondComonentComponent implements OnInit,OnDestroy {

  constructor() { }

  ngOnInit(): void {
  }

  ngOnDestroy(){
    alert("Bye Bye!");
  }

}
