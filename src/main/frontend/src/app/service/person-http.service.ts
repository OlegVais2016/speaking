import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable, of} from "rxjs";
import Person from "../model/person";
import {catchError, tap} from "rxjs/operators";


@Injectable({
  providedIn: 'root'
})
export class PersonHttpService implements HttpInterceptor{
  intercept(req: HttpRequest<any>, next: HttpHandler)
    : Observable<HttpEvent<any>> {
debugger;
    let token = localStorage.getItem("Authorization");

    if (token != null) {
      let requestClone = req.clone({
        headers: new HttpHeaders({
          "Authorization" : token
        })
      });
      return next.handle(requestClone);
    }
    return next.handle(req);
  }
  constructor(private httpClient: HttpClient) { }

  private personsUrlList = 'api/persons/persons';
  private personsUrlSave = 'api/persons/create';
  private personsUrlDelete = 'api/persons/delete';
  private personsUrlLogin = 'api/persons/login';
  private personUrlLogout = 'api/persons/logout';
  private personUrlGetById = 'api/persons/getById';
  private personUrlGetByName = 'api/persons/getByName';
  /*httpOptions = {
    headers: new HttpHeaders(
      { 'Content-Type': 'application/json','Authorization':'token' })
  };*/


  login(email: string, password: string){
    return this.httpClient.post<Person>(this.personsUrlLogin,
      {email:email,password:password}, {observe:"response"});
  }

  logout() {
    return this.httpClient.post<void>(this.personUrlLogout, {});
  }

  getPersonObservable(): Observable<Person[]>{
    return this.httpClient.get<Person[]>(this.personsUrlList)
  }

  addPerson(person:Person):Observable<Person>{
    return this.httpClient.post<Person>(this.personsUrlSave, person)
  }

  deletePerson(person:Person | string): Observable<Person>{
    const personId = typeof person === 'string' ? person : person.personId;
    const url = `${this.personsUrlDelete}/${personId}`;
    return this.httpClient.delete<Person>(url)
  }
  getPerson(person:Person | string):Observable<Person>{
    const personId = typeof person === 'string' ? person : person.personId;
    const url = `${this.personUrlGetById}/${personId}`;
    return this.httpClient.get<Person>(url);
  }
  searchPersons(term: string): Observable<Person[]>{
    if (!term.trim()) {
      // if not search term, return empty person array.
      return of([]);
    }
    return this.httpClient
      .get<Person[]>(`${this.personUrlGetByName}/?firstName=${term}`).pipe(

        catchError(this.handleError<Person[]>('searchPersons', []))
      );

  }
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      // this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}


