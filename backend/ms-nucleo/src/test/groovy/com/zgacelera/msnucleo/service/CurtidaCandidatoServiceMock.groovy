package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.model.dto.CurtidaCandidatoDTO
import com.zgacelera.msnucleo.model.entity.CurtidaCandidato
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class CurtidaCandidatoServiceMock implements CurtidaCandidatoService {

    CurtidaCandidato curtidaCandidato

    CurtidaCandidatoServiceMock(CurtidaCandidato curtidaCandidato) {
        this.curtidaCandidato = curtidaCandidato
    }

    @Override
    CurtidaCandidato curtir(CurtidaCandidatoDTO curtidaCandidatoDTO) {
        return this.curtidaCandidato
    }

    @Override
    List<CurtidaCandidato> buscaTodos() {
        return [curtidaCandidato]
    }

    @Override
    Optional<CurtidaCandidato> buscaPorId(Long id) {
        if (id == 1) {
            Optional.of(curtidaCandidato)
        } else {
            Optional.empty()
        }
    }

    @Override
    void deleta(CurtidaCandidato curtidaCandidato) {
        if (curtidaCandidato.id != 1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curtida não encontrada")
        }
    }
}
