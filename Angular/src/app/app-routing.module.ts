import { NgModule } from '@angular/core';
import { AngformComponent } from './angform/angform.component';
import { CommonModule } from '@angular/common';
import { ShowallComponent } from './showall/showall.component';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes =[
  {path: 'addEmployee/:id',component:AngformComponent},
  {path: 'showAll',component:ShowallComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class AppRoutingModule { }
