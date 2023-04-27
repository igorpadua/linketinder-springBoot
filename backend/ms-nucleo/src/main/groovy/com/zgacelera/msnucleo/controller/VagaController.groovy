package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.dto.VagaDTO
import com.zgacelera.msnucleo.model.entity.Vaga
import com.zgacelera.msnucleo.service.VagaService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/vaga")
@Tag(name = "Vaga", description = "API de Vaga")
class VagaController {

    @Autowired
    VagaService vagaService

    VagaController(VagaService vagaService) {
        this.vagaService = vagaService
    }

    @PostMapping
    @Operation(summary = "Cria uma nova vaga")
    @ApiResponses([
            @ApiResponse(responseCode = "201", description = "Vaga criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação")
    ])
    Vaga salvar(@RequestBody VagaDTO vagaDTO) {
        return vagaService.salvar(vagaDTO)
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma vaga pelo id")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "Vaga encontrada"),
            @ApiResponse(responseCode = "404", description = "Vaga não encontrada")
    ])
    Vaga buscarPorId(@PathVariable Integer id) {
        return vagaService.buscarPorId(id)
                .orElseThrow(
                        { new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada") })
    }

    @GetMapping
    @Operation(summary = "Busca todas as vagas")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "Vagas encontradas")
    ])
    List<Vaga> buscarTodos() {
        return vagaService.buscarTodos()
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma vaga pelo id")
    @ApiResponses([
            @ApiResponse(responseCode = "204", description = "Vaga deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Vaga não encontrada")
    ])
    void deletar(@PathVariable Integer id) {
        vagaService.buscarPorId(id).map { vaga ->
            vagaService.deletar(vaga)
            return Void.TYPE
        }.orElseThrow {
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada")
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma vaga pelo id")
    @ApiResponses([
            @ApiResponse(responseCode = "200", description = "Vaga atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Vaga não encontrada")
    ])
    Vaga atualizar(@PathVariable Integer id, @RequestBody VagaDTO vagaDTO) {
        return vagaService.buscarPorId(id).map { vagaExistente ->
            vagaDTO.id = vagaExistente.id
            vagaService.salvar(vagaDTO)
            return vagaExistente
        }.orElseThrow {
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada")
        }
    }

}

