import { Component, OnInit } from '@angular/core';
import Person from "../../model/person";
import {PersonHttpService} from "../../service/person-http.service";

@Component({
  selector: 'app-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {
  public persons: Person[] = [];
  constructor(private personHttpService: PersonHttpService) { }

  getPersons(){
    return this.personHttpService
      .getPersonObservable()
      .subscribe(data => this.persons = data);
  }

  ngOnInit() {
    this.getPersons();
  }

}
