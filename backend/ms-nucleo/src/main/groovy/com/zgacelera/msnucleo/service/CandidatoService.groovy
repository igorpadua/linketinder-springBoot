package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.model.entity.Candidato

interface CandidatoService {
    Candidato salvar(Candidato candidato)
    Candidato buscarPorId(Integer id)
    List<Candidato> buscarTodos()
    Candidato deletar(Integer id)
}
