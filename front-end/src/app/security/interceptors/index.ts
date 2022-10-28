import { HTTP_INTERCEPTORS } from "@angular/common/http";
import { ErrorInterceptor } from "./error/error.interceptor";
import { JwtInterceptor } from "./jwt/jwt.interceptor";

export const httpInterceptorProviders = [
  {
    provide: HTTP_INTERCEPTORS,
    useClass: JwtInterceptor, 
    multi: true,
  },
  {
    provide: HTTP_INTERCEPTORS, 
    useClass: ErrorInterceptor, 
    multi: true,
  }
];