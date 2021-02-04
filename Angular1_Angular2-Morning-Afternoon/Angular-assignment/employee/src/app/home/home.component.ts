import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
// import Employee from './data.json';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  private _trainUrl = "http://localhost:5500/employee/";

  employee: any;

  emp:any = [];

  postId:any;

  constructor(private http: HttpClient,private router:Router) { }
  
  // Fetching the data from server and load into employee

  ngOnInit(): void {
    
    this.http.get(this._trainUrl)
      .subscribe((Response) => {
        this.employee = Response;
    // this.emp = this.employee.list;
    
    console.log(this.employee);
      })
      
    
  }
  
  // Deleting the employee

  deleteEmployee(endPoints:number) {
    // console.log(endPoints);
    this.http.delete(this._trainUrl + endPoints).subscribe(data => {
      alert("Employee Deleted Successfully.")
      location.reload();

    });
  }

  // Updating the employee

  updateEmployee(id:number){
    this.http.put("http://localhost:5500/employee/posts/" + id ,this.employee).
    subscribe(data => this.postId = this.employee.id);
    alert("Are you sure ? you want to update the details");
    
    // Redirecting to form
    this.router.navigate(['/form/',id]);
  }

}
