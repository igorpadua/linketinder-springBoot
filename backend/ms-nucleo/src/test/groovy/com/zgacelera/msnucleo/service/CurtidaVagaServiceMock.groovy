package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.model.dto.CurtidaVagaDTO
import com.zgacelera.msnucleo.model.entity.CurtidaVaga
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class CurtidaVagaServiceMock implements CurtidaVagaService {

    CurtidaVaga curtidaVaga

    CurtidaVagaServiceMock(CurtidaVaga curtidaVaga) {
        this.curtidaVaga = curtidaVaga
    }

    @Override
    CurtidaVaga salvar(CurtidaVagaDTO curtidaVagaDTO) {
        return curtidaVaga
    }

    @Override
    Optional<CurtidaVaga> buscarPorId(Long id) {
        if (id == 1) {
            Optional.of(curtidaVaga)
        } else {
            Optional.empty()
        }
    }

    @Override
    List<CurtidaVaga> buscarTodas() {
        return [curtidaVaga]
    }

    @Override
    void deletar(CurtidaVaga curtidaVaga) {
        if (curtidaVaga.id != 1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curtida não encontrada")
        }
    }
}
