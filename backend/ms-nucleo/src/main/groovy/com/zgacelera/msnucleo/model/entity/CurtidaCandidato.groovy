package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Canonical
@Table(name = "curtida_candidato")
class CurtidaCandidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    @ManyToOne
    @JoinColumn(name = "candidato_id")
    Candidato candidato
    @ManyToOne
    @JoinColumn(name = "vaga_id")
    Vaga vaga
}
