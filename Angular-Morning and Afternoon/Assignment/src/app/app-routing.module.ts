import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShowdataComponent } from './showdata/showdata.component';
import { InsertdataComponent } from './insertdata/insertdata.component';
const routes: Routes = [{path:"show" , component: ShowdataComponent},
                          {path: '', component: InsertdataComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
