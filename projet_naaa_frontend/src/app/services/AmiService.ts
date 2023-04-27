import { Amis } from './../models/ami.model';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})

export class AmiService {
  private baseUrl = "http://localhost:8080/naaa/api/amis";

  constructor(private http: HttpClient){}

  getAll(ami:any): Observable<Amis[]> {
    return this.http.get<Amis[]>(`${this.baseUrl}/${ami}`);
  }

  getById(id: any): Observable<Amis> {
    return this.http.get<Amis>(`${this.baseUrl}/${id}`);
  }

  create(ami: Amis): Observable<Amis> {
    return this.http.post<Amis>(`${this.baseUrl}/ajouterAmiAmis/${ami.id1}/${ami.id2}`, ami);
  }

  update(ami: Amis): Observable<Amis> {
    return this.http.put<Amis>(`${this.baseUrl}/${ami.id1}/${ami.id2}`, ami);
  }

  delete(ami: Amis): Observable<any> {
    return this.http.delete(`${this.baseUrl}/supprimerAmiAmis/${ami.id1}/${ami.id2}`);
  }

}
