package com.zgacelera.msnucleo.service.impl

import com.zgacelera.msnucleo.dto.CurtidaVagaDTO
import com.zgacelera.msnucleo.model.entity.Candidato
import com.zgacelera.msnucleo.model.entity.CurtidaVaga
import com.zgacelera.msnucleo.model.entity.Vaga
import com.zgacelera.msnucleo.model.repository.CandidatoRepository
import com.zgacelera.msnucleo.model.repository.CurtidaVagaRepository
import com.zgacelera.msnucleo.model.repository.VagaRepository
import com.zgacelera.msnucleo.service.CurtidaVagaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CurtidaVagaServiceImpl implements CurtidaVagaService {

    @Autowired
    CurtidaVagaRepository curtidaVagaRepository
    @Autowired
    CandidatoRepository candidatoRepository
    @Autowired
    VagaRepository vagaRepository

    @Override
    @Transactional
    CurtidaVaga salvar(CurtidaVagaDTO curtidaVagaDTO) {
        Integer vagaId = curtidaVagaDTO.vaga_id
        Vaga vaga = vagaRepository.findById(vagaId).get()
        Integer candidatoId = curtidaVagaDTO.candidato_id
        Candidato candidato = candidatoRepository.findById(candidatoId).get()
        CurtidaVaga curtidaVaga = new CurtidaVaga(candidato: candidato, vaga: vaga)

        return curtidaVagaRepository.save(curtidaVaga)
    }

    @Override
    @Transactional(readOnly = true)
    Optional<CurtidaVaga> buscarPorId(Long id) {
        return curtidaVagaRepository.findById(id)
    }

    @Override
    @Transactional(readOnly = true)
    List<CurtidaVaga> buscarTodas() {
        return curtidaVagaRepository.findAll()
    }

    @Override
    @Transactional
    void deletar(CurtidaVaga curtidaVaga) {
        curtidaVagaRepository.delete(curtidaVaga)
    }
}
