import {Component, Input, OnInit} from '@angular/core';
import Person from "../../../model/person";

@Component({
  selector: 'app-person-page',
  templateUrl: './person-page.component.html',
  styleUrls: ['./person-page.component.css']
})
export class PersonPageComponent implements OnInit {
  @Input()person: Person;
  constructor() { }

  ngOnInit() {
  }

}
