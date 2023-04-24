package com.zgacelera.competencias.controller

import com.zgacelera.competencias.model.Competencia
import com.zgacelera.competencias.service.CompetenciaServiceMock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.server.ResponseStatusException
import spock.lang.Specification

@SpringBootTest
class CompetenciaControllerTest extends Specification {

    CompetenciaController competenciaController
    CompetenciaServiceMock competenciaServiceMock
    Competencia competencia

    void setup() {
        competencia = new Competencia(id: 1L)
        competenciaServiceMock = new CompetenciaServiceMock(competencia)
        competenciaController = new CompetenciaController(competenciaServiceMock)
    }

    void "Salva competencia"() {
        when:
        Competencia competenciaSalva = competenciaController.salva(competencia)

        then:
        competenciaSalva != null
    }

    void "Buscar competencia por id"() {
        when:
        Competencia competenciaSalva = competenciaController.buscaPorId(competencia.id)

        then:
        competenciaSalva != null
    }

    void "Busca competencia por id inexistente"() {
        given:
        Long idInexistente = 2L

        when:
        competenciaController.buscaPorId(idInexistente)

        then:
        thrown(ResponseStatusException)
    }

    void "Busca todas as competencias"() {
        when:
        List<Competencia> competencias = competenciaController.buscaTodas()

        then:
        competencias != null
    }

    void "Deleta competencia"() {
        when:
        competenciaController.deleta(competencia.id)

        then:
        noExceptionThrown()
    }

    void "Deleta competencia inexistente"() {
        given:
        Long idInexistente = 2L

        when:
        competenciaController.deleta(idInexistente)

        then:
        thrown(ResponseStatusException)
    }

    void "Atualiza competencia"() {
        given:
        competencia.nome = "Competencia atualizada"

        when:
        Competencia competenciaAtualizada = competenciaController.atualiza(competencia)

        then:
        competenciaAtualizada != null
    }

    void "Atualiza competencia inexistente"() {
        given:
        Competencia competenciaInexistente = new Competencia(id: 2L)

        when:
        competenciaController.atualiza(competenciaInexistente)

        then:
        thrown(ResponseStatusException)
    }
}
