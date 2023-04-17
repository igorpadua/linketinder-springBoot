package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Entity

@Entity
@Canonical
class Candidato extends Pessoa {
    String sobrenome
    Date dataNascimento
    String cpf
}
