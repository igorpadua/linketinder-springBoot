package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.entity.Vaga
import com.zgacelera.msnucleo.service.VagaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/vaga")
class VagaController {

    @Autowired
    VagaService vagaService

    VagaController(VagaService vagaService) {
        this.vagaService = vagaService
    }

    @GetMapping
    Vaga salvar(Vaga vaga) {
        return vagaService.salvar(vaga)
    }

    @GetMapping("/{id}")
    Vaga buscarPorId(@PathVariable Integer id) {
        return vagaService.buscarPorId(id)
                .orElseThrow(
                { new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada") } )
    }
}
