import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PersonsComponent} from "./content/persons/persons.component";
import {AddComponent} from "./content/persons/add/add.component";

const routes: Routes = [
  {path: 'persons/all', component: PersonsComponent},
  {path: 'persons/save', component: AddComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
