import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CadastroCandidatoComponent } from './components/cadastro-candidato/cadastro-candidato.component';
import {FormsModule} from "@angular/forms";
import { LoginComponent } from './components/login/login.component';
import {RouterOutlet} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";
import { LikeVagaComponent } from './components/like-vaga/like-vaga.component';
import { CadastroEmpresaComponent } from './components/cadastro-empresa/cadastro-empresa.component';
import { CadastroVagaComponent } from './components/cadastro-vaga/cadastro-vaga.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastroCandidatoComponent,
    LoginComponent,
    LikeVagaComponent,
    CadastroEmpresaComponent,
    CadastroVagaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterOutlet,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
