package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Canonical
@Table(name = "empresas")
class Empresa extends Pessoa {
    @Column(name = "cnpj")
    String cnpj
}
