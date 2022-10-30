import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { SoftSkill } from '../model/soft-skill';

@Injectable({
  providedIn: 'root',
})
export class SoftSkillService {
  URL = environment.URL + 'softskill/';

  constructor(private httpClient: HttpClient) {}

  //Mét. propios de la clase para traer lista, traer, guardar, actualizar y borrar skill
  public lista(): Observable<SoftSkill[]> {
    return this.httpClient.get<SoftSkill[]>(this.URL + 'list');
  }

  public detail(id: number): Observable<SoftSkill> {
    return this.httpClient.get<SoftSkill>(this.URL + `detail/${id}`);
  }

  public save(softSkill: SoftSkill): Observable<any> {
    return this.httpClient.post<any>(this.URL + 'create', softSkill);
  }

  public update(id: number, softSkill: SoftSkill): Observable<any> {
    return this.httpClient.put<any>(this.URL + `update/${id}`, softSkill);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete(this.URL + `delete/${id}`);
  }
}
