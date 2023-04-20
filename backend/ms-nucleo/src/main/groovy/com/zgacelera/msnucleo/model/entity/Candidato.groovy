package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.NamedQuery
import jakarta.persistence.Table

@Entity
@Canonical
@Table(name = "candidatos")
@NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c")
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
