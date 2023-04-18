package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
@Canonical
class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id
    String nome
    String descricao
    String local
}
