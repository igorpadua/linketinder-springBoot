package com.zgacelera.msnucleo.model.repository

import com.zgacelera.msnucleo.model.entity.Empresa
import org.springframework.data.jpa.repository.JpaRepository

interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
