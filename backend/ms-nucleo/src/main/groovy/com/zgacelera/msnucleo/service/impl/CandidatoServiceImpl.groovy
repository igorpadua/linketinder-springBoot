package com.zgacelera.msnucleo.service.impl

import com.zgacelera.msnucleo.model.entity.Candidato
import com.zgacelera.msnucleo.model.repository.CandidatoRepository
import com.zgacelera.msnucleo.service.CandidatoService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@RequiredArgsConstructor
class CandidatoServiceImpl implements CandidatoService {

    private final CandidatoRepository candidatoRepository

    CandidatoServiceImpl(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository
    }

    @Override
    @Transactional
    Candidato salvar(Candidato candidato) {
        return candidatoRepository.save(candidato)
    }

    @Override
    @Transactional(readOnly = true)
    Optional<Candidato> buscarPorId(Integer id) {
        return candidatoRepository.findById(id)
    }


    @Override
    @Transactional(readOnly = true)
    List<Candidato> buscarTodos() {
        return candidatoRepository.findAll()
    }

    @Override
    @Transactional
    void deletar(Integer id) {
        candidatoRepository.deleteById(id)
    }

    @Override
    void deletar(Candidato candidato) {
        candidatoRepository.delete(candidato)
    }
}
