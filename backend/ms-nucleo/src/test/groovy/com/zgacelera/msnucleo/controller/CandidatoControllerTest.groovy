package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.entity.Candidato
import com.zgacelera.msnucleo.service.CandidatoServiceMock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.server.ResponseStatusException
import spock.lang.Specification

@SpringBootTest
class CandidatoControllerTest extends Specification {

    CandidatoServiceMock candidatoService
    Candidato candidato

    def setup() {
        candidato = new Candidato()
        candidato.id = 1
        candidatoService = new CandidatoServiceMock(candidato)
    }

    def "Salvar candidato"() {
        when:
        Candidato response = new CandidatoController(candidatoService).salvar(candidato)

        then:
        response != null
    }

    def "Buscar candidato por id"() {
        when:
        Candidato response = new CandidatoController(candidatoService).buscarPorId(1)

        then:
        response != null
        response.id == 1
    }

    def "Buscar candidato por id inexistente"() {
        when:
        new CandidatoController(candidatoService).buscarPorId(4)

        then:
        thrown(ResponseStatusException)
    }

    def "Buscar todos os candidatos"() {
        when:
        List<Candidato> response = new CandidatoController(candidatoService).buscarTodos()

        then:
        response != null
        response.size() == 1
    }

    def "Deletar candidato por id"() {
        when:
        new CandidatoController(candidatoService).deletar(candidato.id)

        then:
        noExceptionThrown()
    }

    def "Deletar candidato por id inexistente"() {
        given:
        final Integer id_inexistente = 2

        when:
        new CandidatoController(candidatoService).deletar(id_inexistente)

        then:
        thrown(ResponseStatusException)
    }
}
