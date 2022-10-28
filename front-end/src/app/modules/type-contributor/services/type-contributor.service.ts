import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MainResponseDTO } from '../../../models/response/main-response-dto';
import { PageResponseDTO } from '../../../models/response/page-response-dto';
import { TypeContributorResponseDTO } from '../../../models/response/type-contributor-response-dto';
import { PathTypeContributor } from '../static/path-type-document';
import { TypeContributorRequestDTO } from '../../../models/request/type-contributitor-request-dto';

@Injectable({
  providedIn: 'root'
})
export class TypeContributorService {

  constructor(
    private _http: HttpClient,
  ) { }

  requestGetAll(): Observable<MainResponseDTO<PageResponseDTO<TypeContributorResponseDTO>>> {
    return this._http.get<MainResponseDTO<PageResponseDTO<TypeContributorResponseDTO>>>(`${PathTypeContributor.GET_ALL}`);
  }

  requestGetById(id: number): Observable<MainResponseDTO<TypeContributorResponseDTO>> {
    return this._http.get<MainResponseDTO<TypeContributorResponseDTO>>(`${PathTypeContributor.GET_BY_ID}/${id}`);
  }

  requestCeate(typeContributorRequestDTO: TypeContributorRequestDTO): Observable<MainResponseDTO<TypeContributorResponseDTO>> {
    return this._http.post<MainResponseDTO<TypeContributorResponseDTO>>(`${PathTypeContributor.CREATE}`, JSON.stringify(typeContributorRequestDTO));
  }

  requestUpdate(typeContributorRequestDTO: TypeContributorRequestDTO, id: number): Observable<MainResponseDTO<TypeContributorResponseDTO>> {
    return this._http.put<MainResponseDTO<TypeContributorResponseDTO>>(`${PathTypeContributor.UPDATE}/${id}`, JSON.stringify(typeContributorRequestDTO));
  }

  requestDelete(id: number): Observable<MainResponseDTO<TypeContributorResponseDTO>> {
    return this._http.delete<MainResponseDTO<TypeContributorResponseDTO>>(`${PathTypeContributor.DELETE}/${id}`);
  }
  
}
