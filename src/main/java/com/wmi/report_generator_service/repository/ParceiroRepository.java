package com.wmi.report_generator_service.repository;

import com.wmi.report_generator_service.repository.entity.ParceiroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParceiroRepository extends JpaRepository<ParceiroEntity, Long> {

    @Query("SELECT p.logo FROM ParceiroEntity p WHERE p.id = :id")
    String findLogoById(@Param("id") Long id);
}
