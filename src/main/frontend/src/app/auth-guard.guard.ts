import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';
import {PersonHttpService} from "./service/person-http.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate {
  constructor(private router: Router, private personHttpService: PersonHttpService) {
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot):
    Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    let token = localStorage.getItem("Authorization");

    let destinationUrl = state.url;
    if (destinationUrl.includes('persons/logout')) {
      this.personHttpService.logout().subscribe();
      localStorage.clear();
      this.router.navigate(['/persons/login']);
      return true;
    }

    if (!token) {
      this.router.navigate(['/persons/login']);
      return false;
    }


    return true;

  }

}
