import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { PathAuthentication } from '../../../modules/authentication/static/path-authentication';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    // HERE CALL LOCALSTORAGE
    const tokenAccess = localStorage.getItem("token_access") || '';
    const tokenType = localStorage.getItem("token_type") || '';
   
    let requestClone = request;
    if(!this.isUrlAuth(request.url)){
      requestClone = request.clone({
        headers: request.headers
          .set('Authorization', `${tokenType} ${tokenAccess}`)
          .set('Content-Type', 'application/json')
      }); 
    }else{
      requestClone = request.clone({
        headers: request.headers
          .set('Content-Type', 'application/json')
      }); 
    }
    return next.handle(requestClone);
  }

  isUrlAuth(url: string): boolean {
    return (url.search(PathAuthentication.ROOT) != -1);
  }

}