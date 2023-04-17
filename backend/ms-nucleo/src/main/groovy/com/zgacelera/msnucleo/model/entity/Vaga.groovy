package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
@Canonical
class Vaga {
    @Id
    Integer id
    String nome
    String descricao
    String local
}
