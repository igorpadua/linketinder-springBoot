import {Component, OnInit} from '@angular/core';
import {Vaga} from "../../model/vaga.model";
import {VagaService} from "../../service/vaga.service";
import {CurtidaCandidatoService} from "../../service/curtida-candidato.service";
import {Curtida} from "../../model/curtida.model";

@Component({
  selector: 'app-like-vaga',
  templateUrl: './like-vaga.component.html',
  styleUrls: ['./like-vaga.component.css']
})
export class LikeVagaComponent implements OnInit {

  vaga: Vaga = {
    nome: '',
    descricao: '',
    local: ''
  }
  vagas: Vaga[] = [];

  idCandidato: number | undefined;

  curtidaCandidato: Curtida = {
    vaga_id: 0,
    candidato_id: 0
  }

  constructor(private vagaService: VagaService, private curtidaCandidatoService: CurtidaCandidatoService) {
  }

  ngOnInit(): void {
    this.vagaService.read().subscribe(vagas => {
      this.vagas = vagas;
      this.vaga = vagas[0];
    });
  }

  proximo() {
    const index = this.vagas.indexOf(this.vaga);
    if (index < this.vagas.length - 1) {
      this.vaga = this.vagas[index + 1];
    } else {
      this.vaga = this.vagas[0];
    }
  }

  like() {
    this.proximo();
    if (this.vaga.id != null && this.idCandidato != null) {
      this.curtidaCandidato.vaga_id = this.vaga.id;
      this.curtidaCandidato.candidato_id = this.idCandidato;
      this.curtidaCandidatoService.create(this.curtidaCandidato).subscribe();
    }
  }

  dislike() {
    this.proximo();
    this.vagas = this.vagas.filter(vaga => vaga.id != this.vaga.id);
  }
}
