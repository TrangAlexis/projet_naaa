import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Coach } from "../models/coach.model";

@Injectable({
  providedIn: 'root',
})
export class CoachService {

  private baseUrl = 'http://localhost:8080/naaa/api/coach';

  constructor(private http: HttpClient) { }

  getCoachs(): Observable<Coach[]> {
    return this.http.get<Coach[]>(`${this.baseUrl}`);
  }

  getCoachByNom(nom: string): Observable<Coach> {
    return this.http.get<Coach>(`${this.baseUrl}/${nom}`);
  }

  createCoach(coach: Coach): Observable<Coach> {
    return this.http.post<Coach>(`${this.baseUrl}/inscription`, coach);
  }

  updateCoach(id: number, coach: Coach): Observable<Coach> {
    return this.http.put<Coach>(`${this.baseUrl}/${id}`, coach);
  }

  deleteCoach(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
}
