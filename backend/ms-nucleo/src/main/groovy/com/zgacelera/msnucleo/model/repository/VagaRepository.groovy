package com.zgacelera.msnucleo.model.repository

import com.zgacelera.msnucleo.model.entity.Vaga
import org.springframework.data.jpa.repository.JpaRepository

interface VagaRepository extends JpaRepository<Vaga, Integer> {
}
