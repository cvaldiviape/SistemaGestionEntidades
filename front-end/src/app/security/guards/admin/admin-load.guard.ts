import { Injectable } from '@angular/core';
import { CanLoad, Route, Router, UrlSegment, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { JwtService } from '../../services/jwt.service';

@Injectable({
  providedIn: 'root'
})
export class AdminLoadGuard implements CanLoad {

  constructor(
    private _jwtService: JwtService,
    private _router: Router,
  ){}

  canLoad(
    route: Route,
    segments: UrlSegment[]
  ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const isLoggedIn = this._jwtService.isAuth();

    if(!isLoggedIn){
      void this._router.navigateByUrl('/auth');
    }
    return isLoggedIn;
  }

}