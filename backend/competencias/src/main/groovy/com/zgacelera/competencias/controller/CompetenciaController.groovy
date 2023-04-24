package com.zgacelera.competencias.controller

import com.zgacelera.competencias.model.Competencia
import com.zgacelera.competencias.service.CompetenciaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/competencia")
class CompetenciaController {

    private final CompetenciaService competenciaService

    CompetenciaController(CompetenciaService competenciaService) {
        this.competenciaService = competenciaService
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Competencia salva(Competencia competencia) {
        competenciaService.salvar(competencia)
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Competencia buscaPorId(@PathVariable Long id) {
        return competenciaService.buscarPorId(id)
                .orElseThrow( () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Competencia não encontrada")
        )
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Competencia> buscaTodas() {
        competenciaService.buscarTodas()
    }
}
