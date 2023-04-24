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

    void setup() {
        competenciaServiceMock = new CompetenciaServiceMock(new Competencia(id: 1L))
        competenciaController = new CompetenciaController(competenciaServiceMock)
    }

    void "Salva competencia"() {
        given:
        Competencia competencia = new Competencia()

        when:
        Competencia competenciaSalva = competenciaController.salva(competencia)

        then:
        competenciaSalva != null
    }

    void "Buscar competencia por id"() {
        given:
        Competencia competencia = new Competencia(id: 1L)

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
}
