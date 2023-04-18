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

    @Override
    Optional<Vaga> buscarPorId(Integer id) {
        if (id == this.vaga.id) {
            return Optional.of(this.vaga)
        }
        return Optional.empty()
    }
}
