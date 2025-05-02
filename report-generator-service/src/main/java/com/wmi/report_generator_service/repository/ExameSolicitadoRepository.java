package com.wmi.report_generator_service.repository;

import com.wmi.report_generator_service.repository.entity.ExameSolicitadoEntity;
import com.wmi.report_generator_service.repository.projection.ExameSolicitadoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExameSolicitadoRepository extends JpaRepository<ExameSolicitadoEntity, Long> {

    List<ExameSolicitadoProjection> findAllByFaturaIdAndParceiroId(Long faturaId, Long parceiroId);
}
