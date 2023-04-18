package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.entity.Candidato
import com.zgacelera.msnucleo.service.CandidatoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/candidato")
class CandidatoController {

    private final CandidatoService candidatoService

    CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Candidato salvar(@RequestBody @Valid Candidato candidato) {
        return candidatoService.salvar(candidato)
    }

    @GetMapping("{id}")
    Candidato buscarPorId(@PathVariable Integer id) {
        return candidatoService.buscarPorId(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato não encontrado"))

    }

    @GetMapping
    List<Candidato> buscarTodos() {
        return candidatoService.buscarTodos()
    }

    @DeleteMapping("{id}")
    void deletar(@PathVariable Integer id) {
        candidatoService.buscarPorId(id).map { candidato ->
            candidatoService.deletar(candidato)
            return Void.TYPE
        }.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato não encontrado"))
    }
}
