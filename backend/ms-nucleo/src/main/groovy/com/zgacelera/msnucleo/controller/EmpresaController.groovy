package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.entity.Empresa
import com.zgacelera.msnucleo.service.EmpresaService
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
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/empresa")
@Tag(name = "Empresa", description = "API de Empresa")
class EmpresaController {

    @Autowired
    private final EmpresaService empresaService

    EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria uma nova empresa")
    @ApiResponses([
        @ApiResponse(responseCode = "201", description = "Empresa criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação")
    ])
    Empresa salvar(@RequestBody Empresa empresa) {
        empresaService.salvar(empresa)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca uma empresa pelo id")
    @ApiResponses([
        @ApiResponse(responseCode = "200", description = "Empresa encontrada"),
        @ApiResponse(responseCode = "404", description = "Empresa não encontrada")
    ])
    Empresa buscarPorId(@PathVariable Integer id) {
        empresaService.buscarPorId(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"))
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca todas as empresas")
    @ApiResponses([
        @ApiResponse(responseCode = "200", description = "Empresas encontradas")
    ])
    List<Empresa> buscarTodos() {
        empresaService.buscarTodos()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta uma empresa pelo id")
    @ApiResponses([
        @ApiResponse(responseCode = "204", description = "Empresa deletada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Empresa não encontrada")
    ])
    void deletar(@PathVariable Integer id) {
        empresaService.buscarPorId(id).map { empresa ->
            empresaService.deletar(empresa)
            return Void.TYPE
        }.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada")
        )
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualiza uma empresa pelo id")
    @ApiResponses([
        @ApiResponse(responseCode = "200", description = "Empresa atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Empresa não encontrada")
    ])
    Empresa atualizar(@PathVariable Integer id, @RequestBody @Valid Empresa empresa) {
        empresaService.buscarPorId(id).map { empresaExistente ->
            empresa.id = empresaExistente.id
            empresaService.salvar(empresa)
            return empresa
        }.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada")
        )
    }
}
