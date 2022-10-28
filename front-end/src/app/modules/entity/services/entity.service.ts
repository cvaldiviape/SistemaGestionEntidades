import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MainResponseDTO } from '../../../models/response/main-response-dto';
import { PageResponseDTO } from '../../../models/response/page-response-dto';
import { EntityResponseDTO } from '../../../models/response/entity-response-dto';
import { EntityRequestDTO } from '../../../models/request/entity-request-dto';
import { PathEntity } from '../static/path-entity';

@Injectable({
  providedIn: 'root'
})
export class EntityService {

  constructor(
    private _http: HttpClient,
  ) { }

  requestGetAll(): Observable<MainResponseDTO<PageResponseDTO<EntityResponseDTO>>> {
    return this._http.get<MainResponseDTO<PageResponseDTO<EntityResponseDTO>>>(`${PathEntity.GET_ALL}`);
  }

  requestGetById(id: number): Observable<MainResponseDTO<EntityResponseDTO>> {
    return this._http.get<MainResponseDTO<EntityResponseDTO>>(`${PathEntity.GET_BY_ID}/${id}`);
  }

  requestCeate(entityRequestDTO: EntityRequestDTO): Observable<MainResponseDTO<EntityResponseDTO>> {
    return this._http.post<MainResponseDTO<EntityResponseDTO>>(`${PathEntity.CREATE}`, JSON.stringify(entityRequestDTO));
  }

  requestUpdate(entityRequestDTO: EntityRequestDTO, id: number): Observable<MainResponseDTO<EntityResponseDTO>> {
    return this._http.put<MainResponseDTO<EntityResponseDTO>>(`${PathEntity.UPDATE}/${id}`, JSON.stringify(entityRequestDTO));
  }

  requestDelete(id: number): Observable<MainResponseDTO<EntityResponseDTO>> {
    return this._http.delete<MainResponseDTO<EntityResponseDTO>>(`${PathEntity.DELETE}/${id}`);
  }

}