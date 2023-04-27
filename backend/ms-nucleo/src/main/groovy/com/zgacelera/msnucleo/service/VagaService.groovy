package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.dto.VagaDTO
import com.zgacelera.msnucleo.model.entity.Vaga

interface VagaService {
    Vaga salvar(VagaDTO vagaDTO)
    Optional<Vaga> buscarPorId(Integer id)
    List<Vaga> buscarTodos()
    void deletar(Vaga vaga)
}