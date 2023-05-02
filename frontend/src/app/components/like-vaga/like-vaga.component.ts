import {Component, OnInit} from '@angular/core';
import {Vaga} from "../../model/vaga.model";
import {VagaServiceService} from "../../service/vaga.service.service";

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

  constructor(private vagaService: VagaServiceService) {
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
  }

  dislike() {
    this.proximo();
  }
}
