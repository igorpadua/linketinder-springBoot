import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Candidato} from "../model/candidato.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CandidatoService {

  baseUrl: string = 'http://localhost:8080/candidato';

  constructor(private http: HttpClient) { }

  showMessage(msg: string): void {
    alert(msg)
  }

  create(candidato: Candidato): Observable<Candidato> {
    return this.http.post<Candidato>(this.baseUrl, candidato);
  }

  read(): Observable<Candidato[]> {
    return this.http.get<Candidato[]>(this.baseUrl);
  }
}
