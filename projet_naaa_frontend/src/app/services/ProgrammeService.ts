import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Programme } from '../models/programmes.model';

@Injectable({
  providedIn: 'root'
})
export class ProgrammeService {
  private apiUrl = 'http://localhost:8080/naaa/api/programme';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Programme[]> {
    return this.http.get<Programme[]>(this.apiUrl);
  }
  getById(id: string): Observable<Programme> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Programme>(url);
  }

  create(programme: Programme): Observable<Programme> {
    return this.http.post<Programme>(`this.apiUrl/ajouter`, programme);
  }

//   updateProgram(program: Program): Observable<void> {
//     const url = `${this.apiUrl}/${program.id}`;
//     return this.http.put<void>(url, program);
//   }

  deleteProgram(id: string): Observable<void> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete<void>(url);
  }
}
