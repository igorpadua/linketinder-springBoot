package com.zgacelera.msnucleo.model.repository

import com.zgacelera.msnucleo.model.entity.Candidato
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
}
