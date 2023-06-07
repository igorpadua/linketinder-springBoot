package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.model.dto.VagaDTO
import com.zgacelera.msnucleo.model.entity.Vaga
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class VagaServiceMock implements VagaService {

    VagaDTO vaga

    VagaServiceMock(VagaDTO vaga) {
        this.vaga = vaga
    }

    @Override
    Vaga salvar(VagaDTO vagaDTO) {
        return  new Vaga(
                id: vagaDTO.id,
                nome: vagaDTO.nome,
                descricao: vagaDTO.descricao,
                local: vagaDTO.local,
        )
    }

    @Override
    Optional<Vaga> buscarPorId(Integer id) {
        if (id == this.vaga.id) {
            return Optional.of(
                    new Vaga(
                            id: this.vaga.id,
                            nome: this.vaga.nome,
                            descricao: this.vaga.descricao,
                            local: this.vaga.local,
                    )
            )
        }
        return Optional.empty()
    }

    @Override
    List<Vaga> buscarTodos() {
        return [
                new Vaga(
                        id: this.vaga.id,
                        nome: this.vaga.nome,
                        descricao: this.vaga.descricao,
                        local: this.vaga.local,
                )
        ]
    }

    @Override
    void deletar(Vaga vaga) {
        if (vaga.id != 1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada")
        }
    }
}
