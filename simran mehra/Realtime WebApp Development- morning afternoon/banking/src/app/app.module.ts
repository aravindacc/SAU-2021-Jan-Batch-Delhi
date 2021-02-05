import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './Components/login/login.component';
import { FormsModule } from '@angular/forms';
import { EmployeeDetailsComponent } from './Components/employee-details/employee-details.component';
import { AdminComponent } from './Components/admin/admin.component';
import { FakeUserComponent } from './Components/fake-user/fake-user.component';
import { DailyWeeklyDepositComponent } from './Components/daily-weekly-deposit/daily-weekly-deposit.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeDetailsComponent,
    AdminComponent,
    FakeUserComponent,
    DailyWeeklyDepositComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
