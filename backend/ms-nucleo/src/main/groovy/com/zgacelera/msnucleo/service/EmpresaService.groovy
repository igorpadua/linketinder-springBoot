package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.model.entity.Empresa

interface EmpresaService {
    Empresa salvar(Empresa empresa)
    Optional<Empresa> buscarPorId(Integer id)
    List<Empresa> buscarTodos()
    void deletar(Empresa empresa)
}