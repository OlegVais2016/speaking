import { Component, OnInit } from '@angular/core';
import Person from "../../../model/person";
import {PersonHttpService} from "../../../service/person-http.service";

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  persons: Person[];
  constructor(private personHttpService: PersonHttpService) { }

  ngOnInit() {
  }
  add(email: string, password: string,
      firstName: string, lastName: string, number: string, age: number): void{
    this.personHttpService.addPerson({email,password, firstName, lastName,
      number, age} as Person)
   .subscribe(person => {
      this.persons.push(person);
    });
  }

  Number(value: string) {
    let age = parseInt(value)
    return age;
  }
}
