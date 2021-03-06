import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PersonsComponent} from "./content/persons/persons.component";
import {AddComponent} from "./content/persons/add/add.component";
import {LoginComponent} from "./content/persons/login/login.component";
import {LogoutComponent} from "./content/persons/logout/logout.component";
import {AuthGuardGuard} from "./auth-guard.guard";
import {PersonDetailComponent} from "./content/persons/person-detail/person-detail.component";
import {PersonSearchComponent} from "./content/persons/person-search/person-search.component";
import {PersonPageComponent} from "./content/persons/person-page/person-page.component";

const routes: Routes = [
  {path: 'persons/save', component: AddComponent},
  {path: 'persons/login', component: LoginComponent},
  {path: 'persons/all', component: PersonsComponent, canActivate: [AuthGuardGuard]},
  {path: 'persons/logout', component: LogoutComponent, canActivate: [AuthGuardGuard]},
  {path: 'detail/:personId', component: PersonDetailComponent},
  {path: 'persons/page', component: PersonPageComponent,canActivate: [AuthGuardGuard]}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
