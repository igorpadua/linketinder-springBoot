package com.zgacelera.competencias.controller

import com.zgacelera.competencias.model.Competencia
import com.zgacelera.competencias.service.CompetenciaServiceMock
import org.springframework.boot.test.context.SpringBootTest
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
}
