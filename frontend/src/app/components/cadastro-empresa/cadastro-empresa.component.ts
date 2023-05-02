import {Component, OnInit} from '@angular/core';
import {Empresa} from "../../model/empresa.model";
import {Router} from "@angular/router";
import {EmpresaService} from "../../service/empresa.service";

@Component({
  selector: 'app-cadastro-empresa',
  templateUrl: './cadastro-empresa.component.html',
  styleUrls: ['./cadastro-empresa.component.css']
})
export class CadastroEmpresaComponent implements OnInit {

  empresa: Empresa = {
    nome: '',
    email: '',
    senha: '',
    cnpj: '',
    descricao: '',
    pais: ''
  }

  constructor(private router: Router, private empresaService: EmpresaService) {
  }

  ngOnInit(): void {
  }

  createEmpresa(): void {
    this.empresaService.create(this.empresa).subscribe(() => {
      this.empresaService.showMessage('Empresa criada com sucesso!')
      this.router.navigate(['/login'])
    })
  }

}
