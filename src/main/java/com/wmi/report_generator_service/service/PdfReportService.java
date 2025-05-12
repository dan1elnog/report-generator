package com.wmi.report_generator_service.service;

import com.google.gson.Gson;
import com.wmi.report_generator_service.controller.response.PdfReportResponseDTO;
import com.wmi.report_generator_service.dto.PdfReportDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JsonDataSource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;

import static java.util.Objects.isNull;

@Service
public class PdfReportService {

    public PdfReportResponseDTO generatePdfReport(PdfReportDTO pdfReportDTO, String reportName, String reportType) throws JRException {
        // Carrega o .jrxml
        InputStream input = getClass().getResourceAsStream("/reports/laudo-raio-x-sem-imagens.jrxml");

        // Compila o relatório
        JasperReport report = JasperCompileManager.compileReport(input);

        String json = new Gson().toJson(pdfReportDTO.getAttributes());

        InputStream jsonInputStream = new ByteArrayInputStream(json.getBytes());
        JsonDataSource jsonDataSource = new JsonDataSource(jsonInputStream);

        // Usa EmptyDataSource para relatórios sem listas
        JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), jsonDataSource);

        String name = isNull(reportName) ? "relatorio" : reportName;
        byte[] pdf = JasperExportManager.exportReportToPdf(print); // Exporta para PDF

        return PdfReportResponseDTO.builder().reportName(name).pdf(pdf).build();
    }
}
