// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs';
// import { Program } from './programs.model';

// @Injectable({
//   providedIn: 'root'
// })
// export class ProgramService {
//   private apiUrl = 'http://localhost:3000/programs';

//   constructor(private http: HttpClient) { }

//   getPrograms(): Observable<Program[]> {
//     return this.http.get<Program[]>(this.apiUrl);
//   }

//   getProgram(id: string): Observable<Program> {
//     const url = `${this.apiUrl}/${id}`;
//     return this.http.get<Program>(url);
//   }

//   addProgram(program: Program): Observable<Program> {
//     return this.http.post<Program>(this.apiUrl, program);
//   }

//   updateProgram(program: Program): Observable<void> {
//     const url = `${this.apiUrl}/${program.id}`;
//     return this.http.put<void>(url, program);
//   }

//   deleteProgram(id: string): Observable<void> {
//     const url = `${this.apiUrl}/${id}`;
//     return this.http.delete<void>(url);
//   }
// }
