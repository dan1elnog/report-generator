package com.wmi.report_generator_service.controller;

import com.wmi.report_generator_service.controller.response.ExcelReportResponseDTO;
import com.wmi.report_generator_service.service.ExcelReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/excel-report")
@RequiredArgsConstructor
public class ExcelReportController {

    private final ExcelReportService excelService;

    @GetMapping
    public ResponseEntity<byte[]> generateReport(
            @RequestParam("invoiceId") Long invoiceId,
            @RequestParam("partnerId") Long partnerId,
            @RequestParam("reportName") String reportName
    ) {
        log.info("receiving request to generate a excel report");
        ExcelReportResponseDTO report = excelService.generateReport(invoiceId, partnerId, reportName);
        return new ResponseEntity<>(report.getBytes(), report.getHttpHeaders(), HttpStatus.OK);
    }
}
