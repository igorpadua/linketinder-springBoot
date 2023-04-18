package com.zgacelera.msnucleo.controller

import com.zgacelera.msnucleo.model.entity.Empresa
import com.zgacelera.msnucleo.service.EmpresaServiceMock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.server.ResponseStatusException
import spock.lang.Specification

@SpringBootTest
class EmpresaControllerTest extends Specification {

    EmpresaServiceMock empresaServiceMock
    Empresa empresa

    void setup() {
        empresa = new Empresa()
        empresa.id = 1
        empresaServiceMock = new EmpresaServiceMock(empresa)
    }

    void "Salva empresa"() {
        when:
        Empresa response = new EmpresaController(empresaServiceMock).salvar(empresa)

        then:
        response != null
    }

    void "Busca empresa por id"() {
        when:
        Empresa response = new EmpresaController(empresaServiceMock).buscarPorId(empresa.id)

        then:
        response != null
    }

    void "Busca empresa por id inexistente"() {
        given:
        final Integer id_inexistente = 2

        when:
        new EmpresaController(empresaServiceMock).buscarPorId(id_inexistente)

        then:
        thrown(ResponseStatusException)
    }


    void "Busca todas as empresas"() {
        when:
        List<Empresa> response = new EmpresaController(empresaServiceMock).buscarTodos()

        then:
        response != null
    }

    void "Deleta empresa"() {
        when:
        new EmpresaController(empresaServiceMock).deletar(empresa.id)

        then:
        noExceptionThrown()
    }

    void "Deleta empresa inexistente"() {
        given:
        final Integer id_inexistente = 2

        when:
        new EmpresaController(empresaServiceMock).deletar(id_inexistente)

        then:
        thrown(ResponseStatusException)
    }

    void "Atualizar empresa"() {
        given:
        empresa.nome = "Empresa 1"

        when:
        Empresa response = new EmpresaController(empresaServiceMock).atualizar(empresa.id, empresa)

        then:
        response != null
        response.nome == "Empresa 1"
    }
}
