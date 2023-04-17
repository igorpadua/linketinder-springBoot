package com.zgacelera.msnucleo.model.repository

import com.zgacelera.msnucleo.model.entity.Empresa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
