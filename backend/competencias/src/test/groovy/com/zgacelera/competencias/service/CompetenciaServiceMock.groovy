package com.zgacelera.competencias.service

import com.zgacelera.competencias.model.Competencia
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class CompetenciaServiceMock implements CompetenciaService {

    Competencia competencia

    CompetenciaServiceMock(Competencia competencia) {
        this.competencia = competencia
    }

    @Override
    Competencia salvar(Competencia competencia) {
        return this.competencia
    }

    @Override
    Optional<Competencia> buscarPorId(Long id) {
        if (id == 1) {
            return Optional.of(this.competencia)
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Competencia não encontrada")
    }

    @Override
    List<Competencia> buscarTodas() {
        return [this.competencia]
    }

    @Override
    void deletar(Competencia competencia) {
        if (competencia.id != 1L) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Competencia não encontrada")
        }
    }
}
