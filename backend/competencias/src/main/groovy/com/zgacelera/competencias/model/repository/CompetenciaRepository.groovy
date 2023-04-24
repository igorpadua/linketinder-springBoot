package com.zgacelera.competencias.model.repository


import com.zgacelera.competencias.model.entity.Competencia
import org.springframework.data.jpa.repository.JpaRepository

interface CompetenciaRepository extends JpaRepository<Competencia, Long> {
}
