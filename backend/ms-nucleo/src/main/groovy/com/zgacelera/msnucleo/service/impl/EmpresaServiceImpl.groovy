package com.zgacelera.msnucleo.service.impl

import com.zgacelera.msnucleo.model.entity.Empresa
import com.zgacelera.msnucleo.model.repository.EmpresaRepository
import com.zgacelera.msnucleo.service.EmpresaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository

    @Override
    @Transactional
    Empresa salvar(Empresa empresa) {
        return empresaRepository.save(empresa)
    }

    @Override
    @Transactional
    Optional<Empresa> buscarPorId(Integer id) {
        return empresaRepository.findById(id)
    }

    @Override
    @Transactional
    List<Empresa> buscarTodos() {
        return empresaRepository.findAll()
    }

    @Override
    @Transactional
    void deletar(Empresa empresa) {
        empresaRepository.delete(empresa)
    }
}
