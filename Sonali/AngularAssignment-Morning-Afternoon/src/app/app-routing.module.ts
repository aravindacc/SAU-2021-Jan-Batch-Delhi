import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddEmployeeComponent} from './add-employee/add-employee.component';
import {UpdateEmployeeComponent} from './update-employee/update-employee.component';
import {DisplayEmployeeComponent} from './display-employee/display-employee.component';

const routes: Routes = [
{path: "add" ,
 component : AddEmployeeComponent
},
{
  path: "update/:id" ,
  component: UpdateEmployeeComponent
},
{
  path: "display" ,
  component: DisplayEmployeeComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
