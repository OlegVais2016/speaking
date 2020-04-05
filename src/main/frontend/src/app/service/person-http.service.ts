import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import Person from "../model/person";
import person from "../model/person";

@Injectable({
  providedIn: 'root'
})
export class PersonHttpService {

  constructor(private httpClient: HttpClient) { }

  private personsUrlList = 'api/persons/persons';
  private personsUrlSave = 'api/persons/create';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  getPersonObservable(): Observable<Person[]>{
    return this.httpClient.get<Person[]>(this.personsUrlList)
  }
  addPerson(person:Person):Observable<Person>{
    return this.httpClient.post<Person>(this.personsUrlSave, person, this.httpOptions)
  }

  /*deletePerson(person:Person | string): Observable<Person>{
    const id = typeof person === 'string' ? person : person.personId;
    const url =
  }*/
}
/*deleteMember (member: Member | number): Observable<Member> {
  const id = typeof member === 'number' ? member : member.id;
const url = `${this.membersUrl}/${id}`;

return this.httpClient.delete<Member>(url, this.httpOptions);
}*/
