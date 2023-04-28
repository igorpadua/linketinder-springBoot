import {Component, OnInit} from '@angular/core';
import {Candidato} from "../../model/candidato.model";

@Component({
  selector: 'app-cadastro-candidato',
  templateUrl: './cadastro-candidato.component.html',
  styleUrls: ['./cadastro-candidato.component.css']
})
export class CadastroCandidatoComponent implements OnInit {

  candidato: Candidato = {
    nome: '',
    sobrenome: '',
    email: '',
    pais: '',
    descricao: '',
    senha: '',
    cpf: '',
    dataNascimento: new Date()
  }

  ngOnInit(): void {
  }

  criarCandidato(): void {
    console.log(this.candidato)
  }

}
