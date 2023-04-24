package com.zgacelera.msnucleo.service

import com.zgacelera.msnucleo.dto.CurtidaCandidatoDTO
import com.zgacelera.msnucleo.model.entity.CurtidaCandidato

interface CurtidaCandidatoService {
    CurtidaCandidato curtir(CurtidaCandidatoDTO curtidaCandidatoDTO)
    List<CurtidaCandidato> buscaTodos()
    Optional<CurtidaCandidato> buscaPorId(Long id)
    void deleta(CurtidaCandidato curtidaCandidato)
}