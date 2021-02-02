import { SvcService } from './../svc.service';
import { Component, OnChanges, OnInit } from '@angular/core';

@Component({
  selector: 'app-sibling',
  templateUrl: './sibling.component.html',
  styleUrls: ['./sibling.component.css']
})
export class SiblingComponent implements OnInit {

  constructor(private svc:SvcService) { }


  num;
  ngOnInit(): void {
    //this.getNumService();

    this.svc.obs.subscribe(data=>{
      this.num=data;
    });

  }

  getNumService(){
    this.num=this.svc.getNum();
  }
  // ngOnChanges(){
  //   this.num=this.svc.getNum();
  // }

}
