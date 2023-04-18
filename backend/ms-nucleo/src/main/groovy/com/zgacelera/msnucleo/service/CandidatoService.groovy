package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.model.entity.Candidato

interface CandidatoService {
    Candidato salvar(Candidato candidato)
    Optional<Candidato> buscarPorId(Integer id)
    List<Candidato> buscarTodos()
    void deletar(Candidato candidato)
}
