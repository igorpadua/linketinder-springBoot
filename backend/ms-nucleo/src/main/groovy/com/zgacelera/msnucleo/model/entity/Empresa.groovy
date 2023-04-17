package com.zgacelera.msnucleo.model.entity

import groovy.transform.Canonical
import jakarta.persistence.Entity

@Entity
@Canonical
class Empresa extends Pessoa {
    String cnpj
}
