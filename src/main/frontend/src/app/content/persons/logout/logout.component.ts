import { Component, OnInit } from '@angular/core';
import {PersonHttpService} from "../../../service/person-http.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-logout',
  template: ''
})
export class LogoutComponent /*implements OnInit*/ {

  constructor(private personHttpService: PersonHttpService/*, private route: Router*/) { }

  /*ngOnInit(): void{
    this.personHttpService.logout().subscribe(data => {
      this.route.navigate(['/persons/login']);
    });
  }*/
 /* ngOnInit(): void{
    this.personHttpService.logout().subscribe();

  }*/
}
