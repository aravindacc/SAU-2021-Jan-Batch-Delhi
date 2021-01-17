import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import {EmployeeDataService} from '../employee-data.service'
import { Router }         from '@angular/router';
import {NgForm} from '@angular/forms'

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.scss']
})
export class EmployeeFormComponent implements OnInit {



  constructor(public sharingService: EmployeeDataService,
    private router:Router) { }

  ngOnInit(): void {
  }

  addUserValue(formVal: NgForm)
  {

    if(this.sharingService.update == true)
    {
      this.sharingService.updateData(formVal.value, this.sharingService.prefilledData.id);
      this.sharingService.update = false;
    }
    else
    {
      this.sharingService.addData(formVal.value);
    }

    formVal.reset();
    //this.router.navigate(['EmployeeFormComponent']);
  }
}
