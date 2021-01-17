import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
import {Route1SeedetailsComponent} from './route1-seedetails/route1-seedetails.component';
import {AppComponent} from './app.component'


const routes: Routes = [
  {
    path: "AppComponent",
    component: AppComponent
  },
  {
    path: "Route1SeedetailsComponent",
    component: Route1SeedetailsComponent
  },
  {
    path: "EmployeeFormComponent",
    component: EmployeeFormComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
