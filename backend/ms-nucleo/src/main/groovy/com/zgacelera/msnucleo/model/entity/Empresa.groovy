package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
@Canonical
class Empresa extends Pessoa {
    @Column(name = "cnpj")
    String cnpj
}
