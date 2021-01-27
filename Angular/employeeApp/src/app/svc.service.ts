import { Injectable } from '@angular/core';
import { Details } from './detail';

@Injectable({
  providedIn: 'root'
})
export class SvcService {

  constructor() { }


  listOfEmployees = new Array<Details>();

  addToService(list:Details){
    this.listOfEmployees.push(list);
  }

  getDetails(){
    return this.listOfEmployees;
  }
}
