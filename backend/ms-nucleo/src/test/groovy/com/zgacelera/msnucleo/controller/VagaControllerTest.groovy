package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.entity.Vaga
import com.zgacelera.msnucleo.service.VagaServiceMock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.server.ResponseStatusException
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

    void "Busca vaga por id"() {
        when:
        Vaga response = new VagaController(vagaServiceMock).buscarPorId(vaga.id)

        then:
        response != null
    }

    void "Busca vaga por id inexistente"() {
        given:
        final Integer id_inexistente = 2

        when:
        new VagaController(vagaServiceMock).buscarPorId(id_inexistente)

        then:
        thrown(ResponseStatusException)
    }

    void "Busca todas as vagas"() {
        when:
        List<Vaga> response = new VagaController(vagaServiceMock).buscarTodos()

        then:
        response != null
    }

    void "Deleta vaga"() {
        when:
        new VagaController(vagaServiceMock).deletar(vaga.id)

        then:
        noExceptionThrown()
    }

    void "Deleta vaga inexistente"() {
        given:
        final Integer id_inexistente = 2

        when:
        new VagaController(vagaServiceMock).deletar(id_inexistente)

        then:
        thrown(ResponseStatusException)
    }

    void "Atualiza vaga"() {
        given:
        vaga.descricao = "Nova descrição"

        when:
        Vaga response = new VagaController(vagaServiceMock).atualizar(vaga.id, vaga)

        then:
        response != null
    }
}
