package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.model.entity.Empresa
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class EmpresaServiceMock implements EmpresaService {

    Empresa empresa

    EmpresaServiceMock(Empresa empresa) {
        this.empresa = empresa
    }

    @Override
    Empresa salvar(Empresa empresa) {
        return this.empresa
    }

    @Override
    Optional<Empresa> buscarPorId(Integer id) {
        if (1 == id) {
            return Optional.of(empresa)
        } else {
            return Optional.empty()
        }
    }

    @Override
    List<Empresa> buscarTodos() {
        return [empresa]
    }

    @Override
    void deletar(Empresa empresa) {
        if (empresa.id != 1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada")
        }
    }
}
