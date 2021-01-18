import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ChildComponent } from './child/child.component';
import { SecondComonentComponent } from './second-comonent/second-comonent.component';
import { SiblingComponent } from './sibling/sibling.component';
import { Route1Component } from './route1/route1.component';
import { Route2Component } from './route2/route2.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { ShowAllEmployeesComponent } from './show-all-employees/show-all-employees.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    ChildComponent,
    SecondComonentComponent,
    SiblingComponent,
    Route1Component,
    Route2Component,
    AddEmployeeComponent,
    ShowAllEmployeesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
