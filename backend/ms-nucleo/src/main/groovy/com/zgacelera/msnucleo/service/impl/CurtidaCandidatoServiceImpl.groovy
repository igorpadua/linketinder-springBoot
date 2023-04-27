package com.zgacelera.msnucleo.service.impl

import com.zgacelera.msnucleo.model.dto.CurtidaCandidatoDTO
import com.zgacelera.msnucleo.model.entity.Candidato
import com.zgacelera.msnucleo.model.entity.CurtidaCandidato
import com.zgacelera.msnucleo.model.entity.Vaga
import com.zgacelera.msnucleo.model.repository.CandidatoRepository
import com.zgacelera.msnucleo.model.repository.CurtidaCandidatoRepository
import com.zgacelera.msnucleo.model.repository.VagaRepository
import com.zgacelera.msnucleo.service.CurtidaCandidatoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CurtidaCandidatoServiceImpl implements CurtidaCandidatoService {

    @Autowired
    CurtidaCandidatoRepository curtidaCandidatoRepository
    @Autowired
    CandidatoRepository candidatoRepository
    @Autowired
    VagaRepository vagaRepository

    @Override
    @Transactional
    CurtidaCandidato curtir(CurtidaCandidatoDTO curtidaCandidatoDTO) {
        Integer candidatoId = curtidaCandidatoDTO.candidato_id
        Candidato candidato = candidatoRepository.findById(candidatoId).get()
        Integer vagaId = curtidaCandidatoDTO.vaga_id
        Vaga vaga = vagaRepository.findById(vagaId).get()
        CurtidaCandidato curtidaCandidato = new CurtidaCandidato(candidato: candidato, vaga: vaga)

        return curtidaCandidatoRepository.save(curtidaCandidato)
    }

    @Override
    @Transactional(readOnly = true)
    List<CurtidaCandidato> buscaTodos() {
        return curtidaCandidatoRepository.findAll()
    }

    @Override
    @Transactional(readOnly = true)
    Optional<CurtidaCandidato> buscaPorId(Long id) {
        return curtidaCandidatoRepository.findById(id)
    }

    @Override
    @Transactional
    void deleta(CurtidaCandidato curtidaCandidato) {
        curtidaCandidatoRepository.delete(curtidaCandidato)
    }
}
