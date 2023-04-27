package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.dto.CurtidaVagaDTO
import com.zgacelera.msnucleo.model.entity.Candidato
import com.zgacelera.msnucleo.model.entity.CurtidaVaga
import com.zgacelera.msnucleo.model.entity.Vaga
import com.zgacelera.msnucleo.service.CurtidaVagaServiceMock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.server.ResponseStatusException
import spock.lang.Specification

@SpringBootTest
class CurtidaVagaControllerTest extends Specification {

    CurtidaVagaServiceMock curtidaVagaService
    CurtidaVaga curtidaVaga

    def setup() {
        curtidaVaga = new CurtidaVaga()
        curtidaVaga.id = 1
        Candidato candidato = new Candidato()
        candidato.id = 1
        curtidaVaga.candidato = candidato
        Vaga vaga = new Vaga()
        vaga.id = 1
        curtidaVaga.vaga = vaga

        curtidaVagaService = new CurtidaVagaServiceMock(curtidaVaga)
    }

    def "Salvar curtidaVaga"() {
        given:
        CurtidaVagaDTO curtidaVaga = new CurtidaVagaDTO(1, 1)

        when:
        CurtidaVaga response = new CurtidaVagaController(curtidaVagaService).curtir(curtidaVaga)

        then:
        response != null
    }

    def "Buscar curtidaVaga por id"() {
        when:
        CurtidaVaga response = new CurtidaVagaController(curtidaVagaService).buscaPorId(1)

        then:
        response != null
        response.id == 1
    }

    def "Buscar curtidaVaga por id inexistente"() {
        when:
        new CurtidaVagaController(curtidaVagaService).buscaPorId(4)

        then:
        thrown(ResponseStatusException)
    }

    def "Buscar todos os curtidaVagas"() {
        when:
        List<CurtidaVaga> response = new CurtidaVagaController(curtidaVagaService).buscaTodas()

        then:
        response != null
        response.size() == 1
    }

    def "Buscar curtidaVaga por candidato"() {
        when:
        CurtidaVaga response = new CurtidaVagaController(curtidaVagaService).buscaPorId(1)

        then:
        response != null
    }

    def "Buscar curtidaVaga por candidato inexistente"() {
        when:
        new CurtidaVagaController(curtidaVagaService).buscaPorId(4)

        then:
        thrown(ResponseStatusException)
    }

    def "Deletar curtidaVaga"() {
        when:
        new CurtidaVagaController(curtidaVagaService).deleta(1)

        then:
        noExceptionThrown()
    }

    def "Deletar curtidaVaga inexistente"() {
        when:
        new CurtidaVagaController(curtidaVagaService).deleta(4)

        then:
        thrown(ResponseStatusException)
    }

}

