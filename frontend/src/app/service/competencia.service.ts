import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Competencia} from "../model/competencia.model";

@Injectable({
  providedIn: 'root'
})
export class CompetenciaService {

  urlBase: string = "http://localhost:8081/competencia"
  constructor(private http: HttpClient) { }

  read(): Observable<Competencia[]> {
    return this.http.get<Competencia[]>(this.urlBase);
  }
}
