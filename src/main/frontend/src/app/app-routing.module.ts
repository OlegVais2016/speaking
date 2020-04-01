import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PersonsComponent} from "./content/persons/persons.component";

const routes: Routes = [
  {path: 'persons', component: PersonsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
