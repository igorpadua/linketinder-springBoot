package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.*

@Canonical
@MappedSuperclass
abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
