import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeeListComponentComponent} from './employee-list-component/employee-list-component.component';
import {EditEmployeeComponent} from './edit-employee/edit-employee.component';

const routes: Routes = [
  {path : "route-list", component : EmployeeListComponentComponent},
  {path : "edit-employee/:name/:id/:age/:dob/:index", component : EditEmployeeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
