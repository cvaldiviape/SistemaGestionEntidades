import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, } from 'rxjs';
import { PathAuthentication } from '../static/path-authentication';
import { AuthResponseDTO } from '../../../models/response/auth-response-dto';
import { UserRequestDTO } from '../../../models/request/user-request-dto';
import { AuthRequestDTO } from '../../../models/request/auth-request-dto';
import { UserResponseDTO } from '../../../models/response/user-response-dto';
import { MainResponseDTO } from '../../../models/response/main-response-dto';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
 
  constructor(
    private _http: HttpClient,
  ) { }

  requestLogin(authRequestDTO: AuthRequestDTO): Observable<MainResponseDTO<AuthResponseDTO>> {
    return this._http.post<MainResponseDTO<AuthResponseDTO>>(PathAuthentication.LOGIN, JSON.stringify(authRequestDTO));
  }

  requestRegister(UserRequestDTO: UserRequestDTO): Observable<MainResponseDTO<UserResponseDTO>> {
    return this._http.post<MainResponseDTO<UserResponseDTO>>(PathAuthentication.REGISTER, JSON.stringify(UserRequestDTO));
  }

}