import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddUsersComponent } from './add-users/add-users.component';
import { DeleteUsersComponent } from './delete-users/delete-users.component';
import { ShowAllUsersComponent } from './show-all-users/show-all-users.component';
import { EditUsersComponent } from './edit-users/edit-users.component';

const routes: Routes = [
  {path: "AddUsers",component: AddUsersComponent},
  {path: "DeleteUsers",component: DeleteUsersComponent},
  {path: "ShowAllUsers",component: ShowAllUsersComponent},
  {path: "EditUsers",component: EditUsersComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
