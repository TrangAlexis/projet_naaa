import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private httpClient: HttpClient) {}

  public authentication(login: string, password: string): Observable<any> {
    let headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa(login + ':' + password),
    });
    return this.httpClient.get('http://localhost:8080/naaa/api/auth', {
      headers: headers,
    });
  }

  public get authenticated(): boolean {
    return sessionStorage.getItem('token') ? true : false;
  }

  public logout() {
    sessionStorage.removeItem('token');
  }

  public isCoach(): boolean {
    const userStr = sessionStorage.getItem('user');
    if (userStr) {
      const user = JSON.parse(userStr);
      return user.role === 'ROLE_COACH';
    } else {
      return false;
    }
  }

}
