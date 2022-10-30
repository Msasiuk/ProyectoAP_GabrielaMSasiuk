import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HardSkill } from '../model/hard-skill';

@Injectable({
  providedIn: 'root',
})
export class HardSkillService {
  URL = environment.URL + 'hardskill/';

  constructor(private httpClient: HttpClient) {}

  //Mét. propios de la clase para traer lista, traer, guardar, actualizar y borrar skill
  public lista(): Observable<HardSkill[]> {
    return this.httpClient.get<HardSkill[]>(this.URL + 'list');
  }

  public detail(id: number): Observable<HardSkill> {
    return this.httpClient.get<HardSkill>(this.URL + `detail/${id}`);
  }

  public save(hardSkill: HardSkill): Observable<any> {
    return this.httpClient.post<any>(this.URL + 'create', hardSkill);
  }

  public update(id: number, hardSkill: HardSkill): Observable<any> {
    return this.httpClient.put<any>(this.URL + `update/${id}`, hardSkill);
  }

  public delete(id: number): Observable<any> {
    return this.httpClient.delete(this.URL + `delete/${id}`);
  }
}
