import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FormComponent } from "./form/form.component";


const routes: Routes = [
  {path:'',redirectTo:'/form',pathMatch:'full' },
  {path:"form", component:FormComponent},
  { path: 'home', component: HomeComponent },
  { path: 'form/:id', component: FormComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const RoutingComponent = [HomeComponent,FormComponent];
