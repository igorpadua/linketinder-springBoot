import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {CadastroCandidatoComponent} from "./components/cadastro-candidato/cadastro-candidato.component";
import {LoginComponent} from "./components/login/login.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: 'cadastro-candidato',
    component: CadastroCandidatoComponent
  },
  {
    path: 'login',
    component: LoginComponent
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

