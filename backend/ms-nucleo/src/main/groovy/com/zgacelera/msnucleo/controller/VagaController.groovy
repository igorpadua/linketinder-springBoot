package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.entity.Vaga
import com.zgacelera.msnucleo.service.VagaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/vaga")
class VagaController {

    @Autowired
    VagaService vagaService

    VagaController(VagaService vagaService) {
        this.vagaService = vagaService
    }

    Vaga salvar(Vaga vaga) {
        return vagaService.salvar(vaga)
    }
}
