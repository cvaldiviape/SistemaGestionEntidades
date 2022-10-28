import { Injectable } from '@angular/core';
import { LocalStorageJwt } from '../static/local-storage-jwt';
import { Jwt } from '../../models/common/jwt';
import { AuthResponseDTO } from '../../../app/models/response/auth-response-dto';

@Injectable({
  providedIn: 'root'
})
export class JwtService {

  constructor() { }

  authJWT(auth: AuthResponseDTO): void {
    localStorage.setItem(LocalStorageJwt.USERNAME, auth.user.username);
    localStorage.setItem(LocalStorageJwt.TOKEN_ACCESS, auth.token.tokenAccess);
    localStorage.setItem(LocalStorageJwt.TOKEN_TYPE, auth.token.tokenType);
    localStorage.setItem(LocalStorageJwt.TOKEN_EXPIRED_IN, auth.token.tokenExpiredIn);
    localStorage.setItem(LocalStorageJwt.ROLE, auth.role.description);
  }

  logout(): void {
    localStorage.removeItem(LocalStorageJwt.USERNAME);
    localStorage.removeItem(LocalStorageJwt.ROLE);
    localStorage.removeItem(LocalStorageJwt.TOKEN_ACCESS);
    localStorage.removeItem(LocalStorageJwt.TOKEN_TYPE);
    localStorage.removeItem(LocalStorageJwt.TOKEN_EXPIRED_IN);
  }

  isAuth(): boolean {
		const role = localStorage.getItem(LocalStorageJwt.TOKEN_ACCESS) || '';
		return (role) ? true : false;
	}

  getUsername(): string{
    return localStorage.getItem(LocalStorageJwt.USERNAME) || '';
  }

  

}