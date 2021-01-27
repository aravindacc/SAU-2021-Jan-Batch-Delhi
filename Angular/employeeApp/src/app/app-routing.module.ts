import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RoutecomponentComponent } from './routecomponent/routecomponent.component';

const routes: Routes = [{
  path:"route",component:RoutecomponentComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
