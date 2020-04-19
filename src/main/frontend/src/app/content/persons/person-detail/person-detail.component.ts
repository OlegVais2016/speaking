import {Component, Input, OnInit} from '@angular/core';
import Person from "../../../model/person";
import person from "../../../model/person";
import {PersonHttpService} from "../../../service/person-http.service";
import {ActivatedRoute, Route} from "@angular/router";

@Component({
  selector: 'app-person-detail',
  templateUrl: './person-detail.component.html',
  styleUrls: ['./person-detail.component.css']
})
export class PersonDetailComponent implements OnInit {

  @Input()person: Person;
  constructor(private personHttpService: PersonHttpService,
              private route: ActivatedRoute) { }

  ngOnInit(): void{
    this.getPerson();
  }
  getPerson():void{
    debugger;
    const id = this.route.snapshot.paramMap.get('personId');
    const personId = id.toString();
    this.personHttpService.getPerson(personId)
      .subscribe(person => this.person = person);
  }
}

