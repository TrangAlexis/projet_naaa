import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Exercice } from '../models/exercise.model';

@Injectable({
  providedIn: 'root',
})
export class ExerciceService {
  private baseUrl = 'http://localhost:3000/exercices';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Exercice[]> {
    return this.http.get<Exercice[]>(`${this.baseUrl}`);
  }

  getById(id: number): Observable<Exercice> {
    return this.http.get<Exercice>(`${this.baseUrl}/${id}`);
  }

  create(exercice: Exercice): Observable<Exercice> {
    return this.http.post<Exercice>(`${this.baseUrl}`, exercice);
  }

//   update(exercice: Exercice): Observable<Exercice> {
//     return this.http.put<Exercice>(`${this.baseUrl}/${exercice.id}`, exercice);
//   }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
