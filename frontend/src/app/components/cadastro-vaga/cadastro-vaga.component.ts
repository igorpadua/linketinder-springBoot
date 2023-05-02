import { Component } from '@angular/core';
import {Vaga} from "../../model/vaga.model";

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

  constructor() { }

  cadastrarVaga() {
    console.log(this.vaga);
  }
}

