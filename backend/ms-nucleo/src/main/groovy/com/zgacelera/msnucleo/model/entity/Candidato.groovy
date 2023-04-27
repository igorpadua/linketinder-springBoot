package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
@Canonical
class Candidato extends Pessoa {
    @Column(name = "sobrenome")
    String sobrenome
    @Column(name = "data_nascimento")
    Date dataNascimento
    @Column(name = "cpf")
    String cpf

    @Override
    String toString() {
        return "Candidato(id: $id, nome: $nome, email: $email, pais: $pais, descricao: $descricao, senha: $senha, sobrenome: $sobrenome, dataNascimento: $dataNascimento, cpf: $cpf)"
    }
}
