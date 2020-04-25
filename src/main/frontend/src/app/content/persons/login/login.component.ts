import { Component, OnInit } from '@angular/core';
import {PersonHttpService} from "../../../service/person-http.service";
import {Router} from "@angular/router";
import {Observable, Subject} from "rxjs";
import Person from "../../../model/person";
import {debounceTime, distinctUntilChanged, switchMap} from "rxjs/operators";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public person: { email: string, password: string } = {email: '', password: ''};
  persons$: Observable<Person[]>;
  private searchTerms = new Subject<string>();
  constructor(private personHttpService: PersonHttpService, private route: Router) { }

 /* ngOnInit() {
  }*/
  login() {

    this.personHttpService
      .login(this.person.email, this.person.password)
      .subscribe(response => {
        localStorage.setItem("Authorization", response.headers.get("Authorization"));
        this.route.navigate(['/persons/page']);
       console.log(response.headers.get("Authorization"));
      })


  }

  search(term: string): void {
    this.searchTerms.next(term);
  }
  ngOnInit(): void {
    this.persons$ = this.searchTerms.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap((term: string) => this.personHttpService.searchPersons(term))
    );
  }
}
