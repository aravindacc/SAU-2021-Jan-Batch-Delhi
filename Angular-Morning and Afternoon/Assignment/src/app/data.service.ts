import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  details: never[] =[];
  sub= new BehaviorSubject([]);
  obs = this.sub.asObservable();


  insertvalues(value: any): void {
    this.details.push(value);
    this.sub.next(this.details);
  }
  showdata(): any {
    return this.details;
  }

  update(i: any,value: any): void{
    console.log(i,value);
	
    this.details[i]= value;
    this.sub.next(this.details);
  }

  delete(i: any): void{
    this.details.splice(i, 1);
  }

  constructor() { }
}
