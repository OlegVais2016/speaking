import { Component, OnInit } from '@angular/core';
import {PersonHttpService} from "../../../service/person-http.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public person: { email: string, password: string } = {email: '', password: ''};

  constructor(private personHttpService: PersonHttpService, private route: Router) { }

  ngOnInit() {
  }
  login() {
    this.personHttpService
      .login(this.person.email, this.person.password)
      .subscribe(response => {
       /* localStorage.setItem("Authorization", response.headers.get("Authorization"));
        this.route.navigate(['/persons/all']);*/
       console.log(response.headers.get("Authorization"));
      })

  }
}
