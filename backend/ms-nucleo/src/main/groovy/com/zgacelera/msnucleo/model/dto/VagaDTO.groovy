package com.zgacelera.msnucleo.model.dto

import groovy.transform.Canonical

@Canonical
class VagaDTO {
    Integer id
    String nome
    String descricao
    String local
    Integer empresaId
}
