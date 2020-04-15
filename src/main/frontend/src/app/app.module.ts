import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ContentComponent } from './content/content.component';
import { PersonsComponent } from './content/persons/persons.component';
import { SeminarsComponent } from './content/seminars/seminars.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { AddComponent } from './content/persons/add/add.component';
import { LoginComponent } from './content/persons/login/login.component';
import { LogoutComponent } from './content/persons/logout/logout.component';
import {PersonHttpService} from "./service/person-http.service";
import { PersonDetailComponent } from './content/persons/person-detail/person-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ContentComponent,
    PersonsComponent,
    SeminarsComponent,
    AddComponent,
    LoginComponent,
    LogoutComponent,
    PersonDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: PersonHttpService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
