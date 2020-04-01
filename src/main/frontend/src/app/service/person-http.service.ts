import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import Person from "../model/person";

@Injectable({
  providedIn: 'root'
})
export class PersonHttpService {

  constructor(private httpClient: HttpClient) { }

  private personsUrl = 'api/persons/persons';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  getPersonObservable(): Observable<Person[]>{
    return this.httpClient.get<Person[]>(this.personsUrl)
  }

}

