package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.model.entity.Candidato
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class CandidatoServiceMock implements CandidatoService {

    Candidato candidato

    CandidatoServiceMock(Candidato candidato) {
        this.candidato = candidato
    }

    @Override
    Candidato salvar(Candidato candidato) {
        return candidato
    }

    @Override
    Optional<Candidato> buscarPorId(Integer id) {
        if (id == 1) {
            Optional.of(candidato)
        } else {
            Optional.empty()
        }
    }

    @Override
    List<Candidato> buscarTodos() {
        return [candidato]
    }

    @Override
    void deletar(Candidato candidato) {
        if (candidato.id != 1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato não encontrado")
        }
    }
}
