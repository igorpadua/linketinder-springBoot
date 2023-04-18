package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.entity.Empresa
import com.zgacelera.msnucleo.service.EmpresaService
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
class EmpresaController {

    @Autowired
    private final EmpresaService empresaService

    EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Empresa salvar(@RequestBody Empresa empresa) {
        empresaService.salvar(empresa)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Empresa buscarPorId(@PathVariable Integer id) {
        empresaService.buscarPorId(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"))
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Empresa> buscarTodos() {
        empresaService.buscarTodos()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
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
