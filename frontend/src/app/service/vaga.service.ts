import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Vaga} from "../model/vaga.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class VagaService {

  baseUrl: string = 'http://localhost:8080/vaga';

  constructor(private http: HttpClient) { }

  showMessage(msg: string): void {
    alert(msg)
  }

  create(vaga: Vaga): Observable<Vaga> {
    return this.http.post<Vaga>(this.baseUrl, vaga);
  }

  read(): Observable<Vaga[]> {
    return this.http.get<Vaga[]>(this.baseUrl);
  }

  readById(id: string): Observable<Vaga> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Vaga>(url);
  }
}
