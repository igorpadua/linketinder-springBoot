import {Component, OnInit} from '@angular/core';
import {Candidato} from "../../model/candidato.model";
import {CandidatoService} from "../../service/candidato.service";
import {Router} from "@angular/router";

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

  constructor(private candidatoService: CandidatoService, private router: Router) {
  }

  ngOnInit(): void {
  }

  criarCandidato(): void {
    this.candidatoService.create(this.candidato).subscribe(() => {
      this.candidatoService.showMessage('Candidato criado com sucesso!');
      this.router.navigate(['/login']);
    });
  }

}
