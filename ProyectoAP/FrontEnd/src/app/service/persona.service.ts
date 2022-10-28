import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root',
})
export class PersonaService {
  // URL = 'http://localhost:8080/personas/';
  // URL = 'https://prueba-msasiuk.herokuapp.com/personas/';
  URL = environment.URL + 'personas/';

  // Mét. constructor
  constructor(private httpClient: HttpClient) {}

  //Mét. propios de la clase para traer lista, traer, guardar, actualizar y borrar educación.
  public lista(): Observable<persona[]> {
    return this.httpClient.get<persona[]>(this.URL + 'lista');
  }

  public detail(id: number): Observable<persona> {
    return this.httpClient.get<persona>(this.URL + `detail/${id}`);
  }

  public update(id: number, Persona: persona): Observable<any> {
    return this.httpClient.put<any>(this.URL + `update/${id}`, Persona);
  }
}
