import { Component } from '@angular/core';
import {Vaga} from "../../model/vaga.model";
import {VagaService} from "../../service/vaga.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-cadastro-vaga',
  templateUrl: './cadastro-vaga.component.html',
  styleUrls: ['./cadastro-vaga.component.css']
})
export class CadastroVagaComponent {

  vaga: Vaga = {
    nome: '',
    descricao: '',
    local: '',
  }

  constructor(private vagaService: VagaService, private router: Router) { }

  cadastrarVaga() {
    this.vagaService.create(this.vaga).subscribe(() => {
      this.vagaService.showMessage('Vaga cadastrada com sucesso!')
      this.router.navigate(['/like-candidato'])
    })
  }
}

