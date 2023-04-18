package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
@Canonical
abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id
    @Column(name = "nome")
    String nome
    @Column(name = "email")
    String email
    @Column(name = "pais")
    String pais
    @Column(name = "descricao")
    String descricao
    @Column(name = "senha")
    String senha
}
