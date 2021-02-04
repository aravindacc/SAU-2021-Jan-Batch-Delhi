import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterEmployeeService {

 // _url = 'http://localhost:5500/employee';

  constructor( private _http:HttpClient) { }

  // register(userData:any){

  //   return this._http.post<any>(this._url,userData);
  // }
}
