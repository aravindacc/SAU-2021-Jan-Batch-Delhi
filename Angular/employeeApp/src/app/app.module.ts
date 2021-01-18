import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { EmployeeformComponent } from './employeeform/employeeform.component';
import { RoutecomponentComponent } from './routecomponent/routecomponent.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeformComponent,
    RoutecomponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
