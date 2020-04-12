import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PersonsComponent} from "./content/persons/persons.component";
import {AddComponent} from "./content/persons/add/add.component";
import {LoginComponent} from "./content/persons/login/login.component";
import {LogoutComponent} from "./content/persons/logout/logout.component";

const routes: Routes = [
  {path: 'persons/save', component: AddComponent},
  {path: 'persons/login', component: LoginComponent},
  {path: 'persons/all', component: PersonsComponent},
  {path: 'persons/logout', component: LogoutComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
