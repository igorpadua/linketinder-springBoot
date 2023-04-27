package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.model.dto.VagaDTO
import com.zgacelera.msnucleo.model.entity.Vaga
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class VagaServiceMock implements VagaService {

    Vaga vaga

    VagaServiceMock(Vaga vaga) {
        this.vaga = vaga
    }

    @Override
    Vaga salvar(VagaDTO vagaDTO) {
        return this.vaga
    }

    @Override
    Optional<Vaga> buscarPorId(Integer id) {
        if (id == this.vaga.id) {
            return Optional.of(this.vaga)
        }
        return Optional.empty()
    }

    @Override
    List<Vaga> buscarTodos() {
        return [this.vaga]
    }

    @Override
    void deletar(Vaga vaga) {
        if (vaga.id != 1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada")
        }
    }
}
