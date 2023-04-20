package com.zgacelera.competencias.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Competencia {
    @Id
    Long id
    String nome
    String nivel
}
