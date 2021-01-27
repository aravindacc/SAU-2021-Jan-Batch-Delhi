import { Component, OnInit } from '@angular/core';
import { Details } from '../detail';
import { SvcService } from '../svc.service';

@Component({
  selector: 'app-routecomponent',
  templateUrl: './routecomponent.component.html',
  styleUrls: ['./routecomponent.component.scss']
})
export class RoutecomponentComponent implements OnInit {

  constructor(
    public svc: SvcService
  ) { }

  listOfEmployees = new Array<Details>();

  ngOnInit(): void {
    this.listOfEmployees = this.svc.getDetails();
  }

  editFunc(item:Details){
    const index = this.listOfEmployees.indexOf(item);
    console.log(this.listOfEmployees[index].isEditedOn);
    this.listOfEmployees[index].isEditedOn = true;
    console.log(this.listOfEmployees[index].isEditedOn);
  }

  deleteFunc(item:Details){
    const index = this.listOfEmployees.indexOf(item);
    if(index>-1){
      this.listOfEmployees.splice(index,1);
    }
  }
  doneEdited(item:Details){
    const index = this.listOfEmployees.indexOf(item);
    this.listOfEmployees[index].isEditedOn = false;
    this.listOfEmployees[index].name =((document.getElementById("nameEdit") as HTMLInputElement).value);
    this.listOfEmployees[index].age = parseInt((document.getElementById("ageEdit") as HTMLInputElement).value);
    this.listOfEmployees[index].dob =((document.getElementById("dobEdit") as HTMLInputElement).value);
  }

}
