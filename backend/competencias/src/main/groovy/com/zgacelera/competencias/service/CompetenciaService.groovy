package com.zgacelera.competencias.service

import com.zgacelera.competencias.model.Competencia
import org.springframework.stereotype.Service

@Service
interface CompetenciaService {
    Competencia salvar(Competencia competencia)
    Optional<Competencia> buscarPorId(Long id)
}
