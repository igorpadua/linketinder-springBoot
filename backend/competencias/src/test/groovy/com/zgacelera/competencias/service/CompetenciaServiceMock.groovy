package com.zgacelera.competencias.service

import com.zgacelera.competencias.model.Competencia

class CompetenciaServiceMock implements CompetenciaService {

    Competencia competencia

    CompetenciaServiceMock(Competencia competencia) {
        this.competencia = competencia
    }

    @Override
    Competencia salvar(Competencia competencia) {
        return this.competencia
    }
}
