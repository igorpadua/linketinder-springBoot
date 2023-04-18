package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.model.entity.Vaga

interface VagaService {
    Vaga salvar(Vaga vaga)
    Optional<Vaga> buscarPorId(Integer id)
    List<Vaga> buscarTodos()
}