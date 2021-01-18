import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { AddUsersComponent } from './add-users/add-users.component';
import { DeleteUsersComponent } from './delete-users/delete-users.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ShowAllUsersComponent } from './show-all-users/show-all-users.component';
import { EditUsersComponent } from './edit-users/edit-users.component';

@NgModule({
  declarations: [
    AppComponent,
    AddUsersComponent,
    DeleteUsersComponent,
    ShowAllUsersComponent,
    EditUsersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
