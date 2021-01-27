import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmplsService {
  list=[];

  constructor() { }

addEmployee(emp):Boolean{
  this.list.push(emp);


  return true;

}
showall(){
  return this.list;
}
}