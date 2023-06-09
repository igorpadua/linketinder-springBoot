package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.dto.CurtidaVagaDTO
import com.zgacelera.msnucleo.model.entity.CurtidaVaga
import com.zgacelera.msnucleo.service.CurtidaVagaService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/curtida-vaga")
@Tag(name = "CurtidaVaga", description = "API de CurtidaVaga")
class CurtidaVagaController {

    private final CurtidaVagaService curtidaVagaService

    CurtidaVagaController(CurtidaVagaService curtidaVagaService) {
        this.curtidaVagaService = curtidaVagaService
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria uma nova curtida")
    @ApiResponses(value = [
            @ApiResponse(responseCode = "201", description = "Curtida criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação")
    ])
    CurtidaVaga curtir(@RequestBody @Valid CurtidaVagaDTO curtidaVagaDTO) {
        return curtidaVagaService.salvar(curtidaVagaDTO)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca todas as curtidas")
    @ApiResponses(value = [
            @ApiResponse(responseCode = "200", description = "Curtidas encontradas")
    ])
    List<CurtidaVaga> buscaTodas() {
        return curtidaVagaService.buscarTodas()
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca uma curtida pelo id")
    @ApiResponses(value = [
            @ApiResponse(responseCode = "200", description = "Curtida encontrada"),
            @ApiResponse(responseCode = "404", description = "Curtida não encontrada")
    ])
    CurtidaVaga buscaPorId(@PathVariable Long id) {
        return curtidaVagaService.buscarPorId(id).orElseThrow(
                { -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curtida não encontrada") }
        )
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta uma curtida pelo id")
    @ApiResponses(value = [
            @ApiResponse(responseCode = "204", description = "Curtida deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Curtida não encontrada")
    ])
    void deleta(@PathVariable Long id) {
        curtidaVagaService.buscarPorId(id).map {
            curtidaVagaService.deletar(it)
            return Void.TYPE
        }.orElseThrow(
                { -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curtida não encontrada") }
        )
    }
}
