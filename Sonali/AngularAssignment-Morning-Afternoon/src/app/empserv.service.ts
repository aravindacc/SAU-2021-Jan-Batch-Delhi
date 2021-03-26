import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class EmpservService {

  constructor(
    private http: HttpClient
  ) { }
  url='http://localhost:3000/employees';
  displayEmployeeData()
  {
    return this.http.get(this.url);
  };
  saveEmployeeData(data :  any)
  {
   // console.log(data);
    return this.http.post(this.url,data);
  }
  deleteEmployeeData(id : any)
  {
    return this.http.delete(`${this.url}/${id}`);
  }
  getCurrentEmployee(id:any)
  {
    return this.http.get(`${this.url}/${id}`);
  }
  updateEmployeeData(id:any,data :any)
  {
    return this.http.put(`${this.url}/${id}`,data);
  }
 }

