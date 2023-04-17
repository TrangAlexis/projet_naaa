import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Client } from "../models/client.model";

@Injectable({
  providedIn: 'root',
})
export class CoachService {

  private baseUrl = 'http://localhost:8080/naaa/api/coach';

  constructor(private http: HttpClient) { }

  getCoachs(): Observable<Client[]> {
    return this.http.get<Client[]>(`${this.baseUrl}`);
  }

  getCoachById(id: number): Observable<Client> {
    return this.http.get<Client>(`${this.baseUrl}/${id}`);
  }

  createCoach(client: Client): Observable<Client> {
    return this.http.post<Client>(`${this.baseUrl}/inscription`, client);
  }

  updateCoach(id: number, client: Client): Observable<Client> {
    return this.http.put<Client>(`${this.baseUrl}/${id}`, client);
  }

  deleteCoach(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
}
