import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule }   from '@angular/forms';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
import { Route1SeedetailsComponent } from './route1-seedetails/route1-seedetails.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeFormComponent,
    Route1SeedetailsComponent
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
