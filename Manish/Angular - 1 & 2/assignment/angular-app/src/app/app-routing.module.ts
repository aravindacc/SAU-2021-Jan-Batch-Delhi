import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddUserComponent } from './component/add-user/add-user.component';
import { AllUserComponent } from './component/all-user/all-user.component';

const routes: Routes = [
  {path:"", component:AddUserComponent},
  {path:"add-user", component:AddUserComponent},
  {path:"all-users", component:AllUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
