import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Observable } from "rxjs";
import { AuthService } from "../services/AuthService";
import { Injectable } from "@angular/core";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) {}

  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    if (this.authService.authenticated) {
      request = request.clone({
        headers: request.headers.set(
          'Authorization',
          'Basic ' + sessionStorage.getItem('token')
        ),
      });
    }
    return next.handle(request);
  }
}
