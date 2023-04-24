import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client } from '../models/client.model';

@Injectable({
  providedIn: 'root',
})
export class ClientService {

  private baseUrl = 'http://localhost:8080/naaa/api/client';

  constructor(private http: HttpClient) { }
  public checkLogin(login: string): Observable<boolean>{
    return this.http.get<boolean>(
      'http://localhost:8080/naaa/api/auth/check/'+ login
    );
  }

  getClients(): Observable<Client[]> {
    return this.http.get<Client[]>(`${this.baseUrl}`);
  }

  getClientByNom(nom: string): Observable<Client> {
    return this.http.get<Client>(`${this.baseUrl}/${nom}`);
  }

  createClient(client: Client): Observable<Client> {
    return this.http.post<Client>(`${this.baseUrl}/inscription`, client);
  }

  updateClient(nom: string, client: Client): Observable<Client> {
    return this.http.put<Client>(`${this.baseUrl}/${nom}`, client);
  }

  deleteClient(nom: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${nom}`, { responseType: 'text' });
  }


}
