import {Component, OnInit} from '@angular/core';
import {Candidato} from "../../model/candidato.model";
import {CandidatoService} from "../../service/candidato.service";
import {CurtidaVagaService} from "../../service/curtida-vaga.service";
import {Curtida} from "../../model/curtida.model";
import {Competencia} from "../../model/competencia.model";
import {CompetenciaService} from "../../service/competencia.service";

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

  competencias: Competencia[] = []

  candidatos: Candidato[] = []

  idVaga: number | undefined

  curtidaVaga: Curtida = {
    candidato_id: 0,
    vaga_id: 0
  }

  constructor(private candidatoService: CandidatoService, private curtidaVagaService: CurtidaVagaService,
              private competenciaService: CompetenciaService) {}

  ngOnInit(): void {
    this.candidatoService.read().subscribe(candidatos => {
      this.candidatos = candidatos
      this.candidatos.forEach(candidato => candidato.dataNascimento = new Date(candidato.dataNascimento))
      this.candidato = this.candidatos[0]
      if (this.candidato.id != null) {
        this.competencias = this.pegaCompetencias(this.candidato.id)
      }
    })
  }

  pegaCompetencias(id: number): Competencia[] {
    let listaCompetencias: Competencia[] = []
    this.competenciaService.read().subscribe(competencias => {
      competencias.forEach(competencia => {
        if (competencia.idPessoa === id && competencia.isVaga === false) {
          listaCompetencias.push(competencia)
        }
      })
    })
    return listaCompetencias
  }

  proximo() {
    let index: number = this.candidatos.indexOf(this.candidato)
    if (index < this.candidatos.length - 1) {
      this.candidato = this.candidatos[index + 1]
      if (this.candidato.id != null) {
        this.competencias = this.pegaCompetencias(this.candidato.id)
      }
    } else {
      this.candidato = this.candidatos[0]
    }
  }

  like() {
    this.proximo()
    if (this.candidato.id != null && this.idVaga != null) {
      this.curtidaVaga.candidato_id = this.candidato.id
      this.curtidaVaga.vaga_id = this.idVaga
      this.curtidaVagaService.create(this.curtidaVaga).subscribe()
    }
  }

  dislike() {
    this.proximo()
    this.candidatos = this.candidatos.filter(candidato => candidato.id != this.candidato.id)
  }

}
