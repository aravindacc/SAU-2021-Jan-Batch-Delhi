import { ShowAllEmployeesComponent } from './show-all-employees/show-all-employees.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { Route2Component } from './route2/route2.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Route1Component } from './route1/route1.component';


const routes: Routes = [
  {path: 'addEmployee/:id',component:AddEmployeeComponent},
  {path: 'showAll',component:ShowAllEmployeesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
