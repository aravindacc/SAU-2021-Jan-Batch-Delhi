import { Component, EventEmitter, Input, OnChanges, OnInit, Output } from '@angular/core';


@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit,OnChanges {

  constructor() { }
  @Input()
  count=0;

  @Output()
  eventExceed5:EventEmitter<string>=new EventEmitter();

  ngOnInit(): void {
  }

  ngOnChanges(){
    if(this.count>5){
      this.eventExceed5.emit("Exceeded");
    }
  }

}
