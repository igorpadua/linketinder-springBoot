import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Curtida} from "../model/curtida.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CurtidaVagaService {

  urlBase: string = 'http://localhost:8080/curtida-vaga'
  constructor(private http: HttpClient) { }

  create(curtidaVaga: Curtida): Observable<Curtida> {
    return this.http.post<Curtida>(this.urlBase, curtidaVaga)
  }
}
