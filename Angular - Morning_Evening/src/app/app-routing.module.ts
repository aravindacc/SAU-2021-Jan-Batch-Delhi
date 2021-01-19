import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeeListComponent} from './employee-list/employee-list.component';
import {EmployeeFormComponent} from './employee-form/employee-form.component';

const routes: Routes = [
  {path : "route-list", component : EmployeeListComponent},
  {path : "edit-employee/:name/:id/:age/:dob/:index", component : EmployeeFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
