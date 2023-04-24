package com.zgacelera.competencias.service.impl


import com.zgacelera.competencias.model.entity.Competencia
import com.zgacelera.competencias.model.repository.CompetenciaRepository
import com.zgacelera.competencias.service.CompetenciaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CompetenciaServiceImpl implements CompetenciaService {

    @Autowired
    CompetenciaRepository competenciaRepository

    @Override
    @Transactional
    Competencia salvar(Competencia competencia) {
        return competenciaRepository.save(competencia)
    }

    @Override
    @Transactional(readOnly = true)
    Optional<Competencia> buscarPorId(Long id) {
        return competenciaRepository.findById(id)
    }

    @Override
    @Transactional(readOnly = true)
    List<Competencia> buscarTodas() {
        return competenciaRepository.findAll()
    }

    @Override
    @Transactional
    void deletar(Competencia competencia) {
        competenciaRepository.delete(competencia)
    }
}
