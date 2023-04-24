package com.zgacelera.competencias.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Competencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String nome
    String nivel
}
