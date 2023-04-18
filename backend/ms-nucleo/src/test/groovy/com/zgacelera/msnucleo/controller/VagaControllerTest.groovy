package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.entity.Vaga
import com.zgacelera.msnucleo.service.VagaServiceMock
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class VagaControllerTest extends Specification {

    VagaServiceMock vagaServiceMock
    Vaga vaga

    void setup() {
        vaga = new Vaga()
        vaga.id = 1
        vagaServiceMock = new VagaServiceMock(vaga)
    }

    void "Salva vaga"() {
        when:
        Vaga response = new VagaController(vagaServiceMock).salvar(vaga)

        then:
        response != null
    }
}
