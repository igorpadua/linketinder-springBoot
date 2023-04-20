package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Canonical
@Table(name = "vagas")
class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id
    String nome
    String descricao
    @Column(name = "local_vaga")
    String local
}
