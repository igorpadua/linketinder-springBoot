package com.zgacelera.competencias.controller

import com.zgacelera.competencias.model.entity.Competencia
import com.zgacelera.competencias.service.CompetenciaService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/competencia")
@Tag(name = "Competencia", description = "API de Competencia")
class CompetenciaController {

    private final CompetenciaService competenciaService

    CompetenciaController(CompetenciaService competenciaService) {
        this.competenciaService = competenciaService
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria uma nova competencia")
    @ApiResponses([
            @ApiResponse(responseCode = "201", description = "Competencia criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação")
    ])
    Competencia salva(@RequestBody @Valid Competencia competencia) {
        return competenciaService.salvar(competencia)
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca uma competencia pelo id")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "Competencia encontrada"),
            @ApiResponse(responseCode = "404", description = "Competencia não encontrada")
    ])
    Competencia buscaPorId(@PathVariable Long id) {
        return competenciaService.buscarPorId(id)
                .orElseThrow( () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Competencia não encontrada")
        )
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca todas as competencias")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "Competencias encontradas")
    ])
    List<Competencia> buscaTodas() {
        competenciaService.buscarTodas()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta uma competencia pelo id")
    @ApiResponses([
            @ApiResponse(responseCode = "204", description = "Competencia deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Competencia não encontrada")
    ])
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
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualiza uma competencia pelo id")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "Competencia atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Competencia não encontrada")
    ])
    Competencia atualiza(@PathVariable Long id, @RequestBody @Valid Competencia competencia) {
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
