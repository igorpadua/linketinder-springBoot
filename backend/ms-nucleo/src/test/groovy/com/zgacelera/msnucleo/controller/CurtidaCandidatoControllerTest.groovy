package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.dto.CurtidaCandidatoDTO
import com.zgacelera.msnucleo.model.entity.Candidato
import com.zgacelera.msnucleo.model.entity.CurtidaCandidato
import com.zgacelera.msnucleo.model.entity.Vaga
import com.zgacelera.msnucleo.service.CurtidaCandidatoServiceMock
import groovy.transform.TypeChecked
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.server.ResponseStatusException
import spock.lang.Specification

@SpringBootTest
class CurtidaCandidatoControllerTest extends Specification {

    CurtidaCandidatoServiceMock curtidaCandidatoService
    CurtidaCandidato curtidaCandidato

    def setup() {
        curtidaCandidato = new CurtidaCandidato()
        curtidaCandidato.id = 1
        Candidato candidato = new Candidato()
        candidato.id = 1
        curtidaCandidato.candidato = candidato
        Vaga vaga = new Vaga()
        vaga.id = 1
        curtidaCandidato.vaga = vaga

        curtidaCandidatoService = new CurtidaCandidatoServiceMock(curtidaCandidato)
    }

    def "Salvar curtidaCandidato"() {
        given:
        CurtidaCandidatoDTO curtidaCandidato = new CurtidaCandidatoDTO(1, 1)

        when:
        CurtidaCandidato response = new CurtidaCandidatoController(curtidaCandidatoService).curtir(curtidaCandidato)

        then:
        response != null
    }

    def "Buscar curtidaCandidato por id"() {
        when:
        CurtidaCandidato response = new CurtidaCandidatoController(curtidaCandidatoService).buscaPorId(1)

        then:
        response != null
        response.id == 1
    }

    def "Buscar curtidaCandidato por id inexistente"() {
        when:
        new CurtidaCandidatoController(curtidaCandidatoService).buscaPorId(4)

        then:
        thrown(ResponseStatusException)
    }

    def "Buscar todos os curtidaCandidatos"() {
        when:
        List<CurtidaCandidato> response = new CurtidaCandidatoController(curtidaCandidatoService).buscaTodas()

        then:
        response != null
        response.size() == 1
    }

    def "Deletar curtidaCandidato por id"() {
        when:
        new CurtidaCandidatoController(curtidaCandidatoService).deletarCurtidasCandidato(curtidaCandidato.id)

        then:
        noExceptionThrown()
    }

    def "Deletar curtidaCandidato por id inexistente"() {
        when:
        new CurtidaCandidatoController(curtidaCandidatoService).deletarCurtidasCandidato(4)

        then:
        thrown(ResponseStatusException)
    }

}
