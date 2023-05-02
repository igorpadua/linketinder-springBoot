import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Empresa} from "../model/empresa.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  baseUrl: string = 'http://localhost:8080/empresa';

  constructor(private http: HttpClient) { }

  showMessage(msg: string): void {
    alert(msg);
  }

  create(empresa: Empresa): Observable<Empresa> {
    return this.http.post<Empresa>(this.baseUrl, empresa);
  }
}
