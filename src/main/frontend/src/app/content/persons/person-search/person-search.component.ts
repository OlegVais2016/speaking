import { Component, OnInit } from '@angular/core';
import {Observable, pipe, Subject} from "rxjs";
import Person from "../../../model/person";
import {PersonHttpService} from "../../../service/person-http.service";
import {debounceTime, distinctUntilChanged, switchMap} from "rxjs/operators";

@Component({
  selector: 'app-person-search',
  templateUrl: './person-search.component.html',
  styleUrls: ['./person-search.component.css']
})
export class PersonSearchComponent implements OnInit {

  persons$: Observable<Person[]>;
  private searchTerms = new Subject<string>();
  constructor(private personHttpService: PersonHttpService) { }
// Push a search term into the observable stream.
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
