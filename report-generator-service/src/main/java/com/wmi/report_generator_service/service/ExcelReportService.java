package com.wmi.report_generator_service.service;

import com.wmi.report_generator_service.controller.response.ExcelReportResponseDTO;
import com.wmi.report_generator_service.dto.ExcelReportDTO;
import com.wmi.report_generator_service.repository.ExameSolicitadoRepository;
import com.wmi.report_generator_service.repository.ParceiroRepository;
import com.wmi.report_generator_service.repository.projection.ExameSolicitadoProjection;
import com.wmi.report_generator_service.util.ExcelUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static com.wmi.report_generator_service.util.ConstantsUtil.EXCEL_REPORT_HEADERS;
import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class ExcelReportService {

    private final ExcelUtil excelUtil;
    private final ExameSolicitadoRepository exameSolicitadoRepository;
    private final ParceiroRepository parceiroRepository;

    public ExcelReportResponseDTO generateReport(Long invoiceId, Long partnerId) {
        List<ExcelReportDTO> excelReportRegisters = generateExcelReportRegisters(invoiceId, partnerId);
        String logo = parceiroRepository.findLogoById(partnerId);

        if (excelReportRegisters.isEmpty()) {
            throw new RuntimeException("registers not found for invoiceId = %s and partner = %s".formatted(invoiceId, partnerId));
        }

        return excelUtil.generateExcel(EXCEL_REPORT_HEADERS, excelReportRegisters, logo);
    }

    private List<ExcelReportDTO> generateExcelReportRegisters(Long invoiceId, Long partnerId) {
        List<ExcelReportDTO> excelReportRegisters = new ArrayList<>();
        List<ExameSolicitadoProjection> projectionList = exameSolicitadoRepository.findAllByFaturaIdAndParceiroId(invoiceId, partnerId);

        for (ExameSolicitadoProjection projection : projectionList) {
            ExcelReportDTO excelReportDTO = new ExcelReportDTO(
                    ofNullable(projection.getPaciente()).map(ExameSolicitadoProjection.PacienteProjection::getNomePaciente).orElse(null),
                    ofNullable(projection.getEmpresa()).map(ExameSolicitadoProjection.EmpresaProjection::getNomeFantasia).orElse(null),
                    ofNullable(projection.getExame()).map(ExameSolicitadoProjection.ExameProjection::getNomeExame).orElse(null),
                    projection.getIndicacao(),
                    isNull(projection.getPreco()) ? null : "R$ ".concat(projection.getPreco().setScale(2, RoundingMode.HALF_UP).toString()),
                    isNull(projection.getDataExame()) ? null : projection.getDataExame().toString(),
                    isNull(projection.getDataLaudo()) ? null : projection.getDataLaudo().toString(),
                    projection.getStatus(),
                    isNull(projection.getDataCriacao()) ? null : projection.getDataCriacao().toString(),
                    isNull(projection.getUsuario()) ? null : projection.getUsuario().getUserName()
            );

            excelReportRegisters.add(excelReportDTO);
        }

        return excelReportRegisters;
    }
}
