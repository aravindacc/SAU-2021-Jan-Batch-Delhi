import { Component, OnInit } from '@angular/core';
import {EmployeeDataService} from '../employee-data.service'
import { Router }         from '@angular/router';
import {EmployeeFormComponent} from '../employee-form/employee-form.component'

@Component({
  selector: 'app-route1-seedetails',
  templateUrl: './route1-seedetails.component.html',
  styleUrls: ['./route1-seedetails.component.scss']
})
export class Route1SeedetailsComponent implements OnInit {


  constructor(public sharingService: EmployeeDataService,
    private router:Router)
    { };

  editData(id: any)
  {
    this.sharingService.editData(id);
  }

  deleteData(id: any)
  {
    this.sharingService.deleteData(id);
  }

  addData()
  {
    this.router.navigate(['EmployeeFormComponent']);
  }

  ngOnInit(): void {
  }

}
