package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.*

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
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    Empresa empresa
}
