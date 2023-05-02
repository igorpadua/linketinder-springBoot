import {Component, OnInit} from '@angular/core';
import {Candidato} from "../../model/candidato.model";
import {CandidatoService} from "../../service/candidato.service";

@Component({
  selector: 'app-like-candidato',
  templateUrl: './like-candidato.component.html',
  styleUrls: ['./like-candidato.component.css']
})
export class LikeCandidatoComponent implements OnInit {

  candidato: Candidato = {
    id: 0,
    nome: '',
    sobrenome: '',
    email: '',
    pais: '',
    senha: '',
    cpf: '',
    dataNascimento: new Date(),
    descricao: ''
  }

  candidatos: Candidato[] = []

  constructor(private candidatoService: CandidatoService) {}

  ngOnInit(): void {
    this.candidatoService.read().subscribe(candidatos => {
      this.candidatos = candidatos
      this.candidatos.forEach(candidato => candidato.dataNascimento = new Date(candidato.dataNascimento))
      this.candidato = this.candidatos[0]
    })
  }

  proximo() {
    let index = this.candidatos.indexOf(this.candidato)
    if (index < this.candidatos.length - 1) {
      this.candidato = this.candidatos[index + 1]
    } else {
      this.candidato = this.candidatos[0]
    }
  }

  like() {
    this.proximo()
  }

  dislike() {
    this.proximo()
  }

}
