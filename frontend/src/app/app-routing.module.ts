import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {CadastroCandidatoComponent} from "./components/cadastro-candidato/cadastro-candidato.component";
import {LoginComponent} from "./components/login/login.component";
import {LikeVagaComponent} from "./components/like-vaga/like-vaga.component";
import {CadastroEmpresaComponent} from "./components/cadastro-empresa/cadastro-empresa.component";
import {CadastroVagaComponent} from "./components/cadastro-vaga/cadastro-vaga.component";
import {LikeCandidatoComponent} from "./components/like-candidato/like-candidato.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'cadastro-candidato',
    component: CadastroCandidatoComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'like-vaga',
    component: LikeVagaComponent
  },
  {
    path: 'cadastro-empresa',
    component: CadastroEmpresaComponent
  },
  {
    path: 'cadastro-vaga',
    component: CadastroVagaComponent
  },
  {
    path: 'like-candidato',
    component: LikeCandidatoComponent
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

