package com.zgacelera.msnucleo.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "curtida_vaga")
class CurtidaVaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    @ManyToOne
    @JoinColumn(name = "vaga_id")
    Vaga vaga
    @ManyToOne
    @JoinColumn(name = "candidato_id")
    Candidato candidato
}
