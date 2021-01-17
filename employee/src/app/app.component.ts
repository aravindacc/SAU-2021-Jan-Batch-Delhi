import { Component } from '@angular/core';
import {EmployeeDataService} from './employee-data.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'employee';

  private databaseObj: EmployeeDataService;
  constructor() { }

}
