package com.zgacelera.competencias.controller

import com.zgacelera.competencias.model.entity.Competencia
import com.zgacelera.competencias.service.CompetenciaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
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
    Competencia salva(@RequestBody Competencia competencia) {
        return competenciaService.salvar(competencia)
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleta(@PathVariable Long id) {
        competenciaService.buscarPorId(id)
        .map { competencia ->
            competenciaService.deletar(competencia)
            return Void.TYPE
        }.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competencia não encontrada")
        )
    }

    @PutMapping("/{id}")
    Competencia atualiza(@PathVariable Long id, @RequestBody Competencia competencia) {
        competenciaService.buscarPorId(id)
                .map { competenciaExistente ->
                    competencia.id = competenciaExistente.id
                    competenciaService.salvar(competencia)
                    return competencia
                }.orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competencia não encontrada")
                )
    }
}
