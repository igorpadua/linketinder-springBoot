import { Injectable } from '@angular/core';
import {Curtida} from "../model/curtida.model";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CurtidaCandidatoService {

  urlBase = 'http://localhost:8080/curtida-candidato'
  constructor(private http: HttpClient) {}

  create(curtidaCandidato: Curtida): Observable<Curtida> {
    return this.http.post<Curtida>(this.urlBase, curtidaCandidato)
  }
}
