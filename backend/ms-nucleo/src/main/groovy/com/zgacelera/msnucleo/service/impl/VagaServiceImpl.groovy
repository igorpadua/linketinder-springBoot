package com.zgacelera.msnucleo.service.impl

import com.zgacelera.msnucleo.model.dto.VagaDTO
import com.zgacelera.msnucleo.model.entity.Empresa
import com.zgacelera.msnucleo.model.entity.Vaga
import com.zgacelera.msnucleo.model.repository.EmpresaRepository
import com.zgacelera.msnucleo.model.repository.VagaRepository
import com.zgacelera.msnucleo.service.VagaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class VagaServiceImpl implements VagaService {

    @Autowired
    VagaRepository vagaRepository
    @Autowired
    EmpresaRepository empresaRepository

    VagaServiceImpl(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository
    }

    @Override
    @Transactional
    Vaga salvar(VagaDTO vagaDTO) {
        String nome = vagaDTO.nome
        String descricao = vagaDTO.descricao
        String local = vagaDTO.local
        Integer empresaId = vagaDTO.empresaId
        Empresa empresa = empresaRepository.findById(empresaId).get()
        Vaga vaga = new Vaga(nome: nome, descricao: descricao, local: local, empresa: empresa)

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
