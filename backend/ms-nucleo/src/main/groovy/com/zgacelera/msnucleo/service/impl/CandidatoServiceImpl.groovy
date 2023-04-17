package com.zgacelera.msnucleo.service.impl

import com.zgacelera.msnucleo.model.entity.Candidato
import com.zgacelera.msnucleo.model.repository.CandidatoRepository
import com.zgacelera.msnucleo.service.CandidatoService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class CandidatoServiceImpl implements CandidatoService {

    private final CandidatoRepository candidatoRepository

    @Override
    Candidato salvar(Candidato candidato) {
        return candidatoRepository.save(candidato)
    }

    @Override
    Candidato buscarPorId(Integer id) {
        return candidatoRepository.findById(id)
    }

    @Override
    List<Candidato> buscarTodos() {
        return candidatoRepository.findAll()
    }

    @Override
    Candidato deletar(Integer id) {
        return candidatoRepository.deleteById(id)
    }
}
