package com.zgacelera.msnucleo.model.repository

import com.zgacelera.msnucleo.model.entity.Vaga
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VagaRepository extends JpaRepository<Vaga, Integer> {
}
