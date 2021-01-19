import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShowdataComponent } from './showdata/showdata.component';
import { InsertdataComponent } from './insertdata/insertdata.component';
import {DataService} from './data.service';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import {CommonModule } from '@angular/common';
@NgModule({
  declarations: [
    AppComponent,
    ShowdataComponent,
    InsertdataComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    CommonModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
