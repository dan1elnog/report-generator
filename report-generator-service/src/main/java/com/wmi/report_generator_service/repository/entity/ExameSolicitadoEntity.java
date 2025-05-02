package com.wmi.report_generator_service.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "examesolicitados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExameSolicitadoEntity {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteEntity paciente;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private EmpresaEntity empresa;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "faturaparceiro_id")
    private FaturaParceiroEntity fatura;

    @ManyToOne
    @JoinColumn(name = "parceiro_id")
    private ParceiroEntity parceiro;

    @ManyToOne
    @JoinColumn(name = "exame_id")
    private ExameEntity exame;

    @Column(name = "indicacao")
    private String indicacao;

    @Column(name = "precoparceiro")
    private BigDecimal preco;

    @Column(name = "dataexame")
    private LocalDate dataExame;

    @Column(name = "datalaudo")
    private LocalDateTime dataLaudo;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private LocalDateTime dataCriacao;
}
