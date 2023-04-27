package com.zgacelera.competencias.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Canonical
@Table(name = "competencias")
class Competencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String nome
    String nivel
    @Column(name = "id_pessoa")
    Long idPessoa
    @Column(name = "id_vaga")
    Boolean isVaga

}
