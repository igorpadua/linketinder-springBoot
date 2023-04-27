package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.model.dto.CurtidaVagaDTO
import com.zgacelera.msnucleo.model.entity.CurtidaVaga

interface CurtidaVagaService {
    CurtidaVaga salvar(CurtidaVagaDTO curtidaVagaDTO)
    Optional<CurtidaVaga> buscarPorId(Long id)
    List<CurtidaVaga> buscarTodas()
    void deletar(CurtidaVaga curtidaVaga)
}
