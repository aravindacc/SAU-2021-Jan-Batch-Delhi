import { Component, OnInit } from '@angular/core';
import { EmpservService } from '../empserv.service';
@Component({
  selector: 'app-display-employee',
  templateUrl: './display-employee.component.html',
  styleUrls: ['./display-employee.component.scss']
})
export class DisplayEmployeeComponent implements OnInit {

  constructor(
    private empdata:EmpservService
  ) { }
collection:any=[];
  ngOnInit(): void {
    this.empdata.displayEmployeeData().subscribe((data)=>{
     // console.log(data);
      this.collection=data;
    });
  }

  deleteEmployee(data :any)
  {
      //console.log(this.collection);
      //this.collection.splice(data-1,1);
      this.empdata.deleteEmployeeData(data).subscribe((result)=>{
            console.log(result);
      })
      this.empdata.displayEmployeeData().subscribe((data)=>{
        // console.log(data);
         this.collection=data;
       });

  }
  EditEmployee(data :any)
  {

  }
}
