package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.entity.Candidato
import com.zgacelera.msnucleo.service.CandidatoService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/candidato")
@Tag(name = "Candidato", description = "API de Candidato")
class CandidatoController {

    private final CandidatoService candidatoService

    CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria um novo candidato")
    @ApiResponses([
            @ApiResponse(responseCode = "201", description = "Candidato criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação")
    ])
    Candidato salvar(@RequestBody @Valid Candidato candidato) {
        return candidatoService.salvar(candidato)
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca um candidato pelo id")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "Candidato encontrado"),
            @ApiResponse(responseCode = "404", description = "Candidato não encontrado")
    ])
    Candidato buscarPorId(@PathVariable Integer id) {
        return candidatoService.buscarPorId(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato não encontrado"))

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca todos os candidatos")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "Candidatos encontrados")
    ])
    List<Candidato> buscarTodos() {
        return candidatoService.buscarTodos()
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta um candidato pelo id")
    @ApiResponses([
            @ApiResponse(responseCode = "204", description = "Candidato deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Candidato não encontrado")
    ])
    void deletar(@PathVariable Integer id) {
        candidatoService.buscarPorId(id).map { candidato ->
            candidatoService.deletar(candidato)
            return Void.TYPE
        }.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato não encontrado"))
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualiza um candidato pelo id")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "Candidato atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Candidato não encontrado")
    ])
    Candidato atualizar(@PathVariable Integer id, @RequestBody @Valid Candidato candidato) {
        return candidatoService.buscarPorId(id).map { candidatoExistente ->
            candidato.id = candidatoExistente.id
            return candidatoService.salvar(candidato)
        }.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato não encontrado"))
    }
}
