package com.zgacelera.competencias.controller

import com.zgacelera.competencias.model.Competencia
import com.zgacelera.competencias.service.CompetenciaService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/competencia")
class CompetenciaController {

    private final CompetenciaService competenciaService

    CompetenciaController(CompetenciaService competenciaService) {
        this.competenciaService = competenciaService
    }

    @PostMapping
    Competencia salva(Competencia competencia) {
        competenciaService.salvar(competencia)
    }


}
