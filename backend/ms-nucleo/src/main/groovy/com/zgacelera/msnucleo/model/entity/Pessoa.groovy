package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
@Canonical
class Pessoa {
    @Id
    Integer id
    String nome
    String email
    String pais
    String descricao
    String senha
}
