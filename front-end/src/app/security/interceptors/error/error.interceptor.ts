import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse
} from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { Router } from '@angular/router';
import { SnackBarService } from '../../../shared/services/snack-bar.service';
import { MessagesBackend } from '../../../constants/messages-backend';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

  constructor(
    private _router: Router,
    private _snackBar: SnackBarService
  ) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    return next.handle(request).pipe(
      catchError(err => {
        return this.errorHandler(err); 
      }
    ));
  }

  errorHandler(err: HttpErrorResponse){
    if(err?.status){
      this.showSnackbarByStatus(err);
    }
    return throwError(() => err);
  }

  showSnackbarByStatus(err: HttpErrorResponse): void{
    switch(err.status){
      case 400:
        if(err.error?.message) this._snackBar.showError(err.error.message, 'bottom center');
        break;
      case 401:
        this._snackBar.showError(MessagesBackend.UNAUTHORIZED, 'top right');
        this._router.navigateByUrl('/auth/sign-in');
        break;
      default:
        this._snackBar.showError(MessagesBackend.UNKNOWN_ERROR, 'top right');
        break;
    }
  }
 
}