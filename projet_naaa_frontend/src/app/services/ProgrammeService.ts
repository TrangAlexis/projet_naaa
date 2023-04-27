import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Program } from '../models/programmes';

@Injectable({
  providedIn: 'root'
})
export class ProgrammeService {
  private apiUrl = 'http://localhost:8080/naaa/api/programme';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Program[]> {
    return this.http.get<Program[]>(this.apiUrl);
  }
  getById(id: number): Observable<Program> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Program>(url);
  }

  create(programme: Program): Observable<Program> {
    return this.http.post<Program>(`${this.apiUrl}/ajouter`, programme);
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
