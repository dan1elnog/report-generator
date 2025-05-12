package com.wmi.report_generator_service.controller;

import com.wmi.report_generator_service.controller.response.PdfReportResponseDTO;
import com.wmi.report_generator_service.dto.GeneratePdfDTO;
import com.wmi.report_generator_service.dto.PdfReportDTO;
import com.wmi.report_generator_service.service.PdfReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/pdf-report")
@RequiredArgsConstructor
public class PdfReportController {

    private final PdfReportService pdfReportService;

    @GetMapping
    public ResponseEntity<byte[]> generateReport(
            @RequestHeader(value = "reportName", required = false) String reportName,
            @RequestHeader(value = "reportType", required = false) String reportType,
            @RequestBody PdfReportDTO pdfReportDTO
    ) throws JRException {
        log.info("receiving request to generate a pdf report with request == {}, report name == {} and report type == {}", pdfReportDTO, reportName, reportType);

        PdfReportResponseDTO response = pdfReportService.generatePdfReport(pdfReportDTO, reportName, reportType);
        return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename="+ response.getReportName() +".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(response.getPdf());
    }
}
