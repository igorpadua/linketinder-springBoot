package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.entity.Vaga
import com.zgacelera.msnucleo.service.VagaService
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
class VagaController {

    @Autowired
    VagaService vagaService

    VagaController(VagaService vagaService) {
        this.vagaService = vagaService
    }

    @PostMapping
    Vaga salvar(@RequestBody Vaga vaga) {
        return vagaService.salvar(vaga)
    }

    @GetMapping("/{id}")
    Vaga buscarPorId(@PathVariable Integer id) {
        return vagaService.buscarPorId(id)
                .orElseThrow(
                        { new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada") })
    }

    @GetMapping
    List<Vaga> buscarTodos() {
        return vagaService.buscarTodos()
    }

    @DeleteMapping("/{id}")
    void deletar(@PathVariable Integer id) {
        vagaService.buscarPorId(id).map { vaga ->
            vagaService.deletar(vaga)
            return Void.TYPE
        }.orElseThrow {
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada")
        }
    }

    @PutMapping("/{id}")
    Vaga atualizar(@PathVariable Integer id, @RequestBody Vaga vaga) {
        return vagaService.buscarPorId(id).map { vagaExistente ->
            vaga.id = vagaExistente.id
            vagaService.salvar(vaga)
            return vaga
        }.orElseThrow {
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada")
        }
    }
}
