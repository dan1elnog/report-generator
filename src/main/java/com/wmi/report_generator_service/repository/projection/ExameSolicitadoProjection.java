package com.wmi.report_generator_service.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ExameSolicitadoProjection {

    EmpresaProjection getEmpresa();

    PacienteProjection getPaciente();

    ExameProjection getExame();

    UsuarioProjection getUsuario();

    String getStatus();

    String getIndicacao();

    BigDecimal getPreco();

    LocalDateTime getDataLaudo();

    LocalDate getDataExame();

    LocalDateTime getDataCriacao();

    interface EmpresaProjection {
        String getNomeFantasia();
    }

    interface PacienteProjection {
        String getNomePaciente();
    }

    interface ExameProjection {
        String getNomeExame();
    }

    interface UsuarioProjection {
        String getUserName();
    }
}



