package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.model.entity.Vaga

class VagaServiceMock implements VagaService {

    Vaga vaga

    VagaServiceMock(Vaga vaga) {
        this.vaga = vaga
    }

    @Override
    Vaga salvar(Vaga vaga) {
        return this.vaga
    }
}
