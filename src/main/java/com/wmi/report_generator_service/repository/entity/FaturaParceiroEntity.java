package com.wmi.report_generator_service.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "faturaparceiros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaturaParceiroEntity {

    @Id
    @Column
    private Long id;

    @Column(name = "laudado")
    private Integer laudado;

    @Column(name = "repetir")
    private Integer repetir;

    @Column(name = "pendente")
    private Integer pendente;

    @Column(name = "parceiro_id")
    private Long parceiroId;

    @Column(name = "datainicial")
    private LocalDateTime dataInicial;

    @Column(name = "datafinal")
    private LocalDateTime dataFinal;

    @Column(name = "pago")
    private LocalDateTime pago;

    @Column(name = "valortotal", precision = 15, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
