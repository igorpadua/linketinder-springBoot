package com.zgacelera.msnucleo.service.impl

import com.zgacelera.msnucleo.model.entity.Vaga
import com.zgacelera.msnucleo.model.repository.VagaRepository
import com.zgacelera.msnucleo.service.VagaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class VagaServiceImpl implements VagaService {

    @Autowired
    VagaRepository vagaRepository

    VagaServiceImpl(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository
    }

    @Override
    @Transactional
    Vaga salvar(Vaga vaga) {
        return vagaRepository.save(vaga)
    }

    @Override
    @Transactional(readOnly = true)
    Optional<Vaga> buscarPorId(Integer id) {
        return vagaRepository.findById(id)
    }

    @Override
    @Transactional(readOnly = true)
    List<Vaga> buscarTodos() {
        return vagaRepository.findAll()
    }

    @Override
    @Transactional
    void deletar(Vaga vaga) {
        vagaRepository.delete(vaga)
    }
}
