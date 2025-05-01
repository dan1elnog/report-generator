package com.wmi.report_generator_service.controller;

import com.wmi.report_generator_service.controller.response.ExcelReportResponseDTO;
import com.wmi.report_generator_service.service.ExcelReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/excel-report")
@RequiredArgsConstructor
public class ExcelReportController {

    @Autowired
    private final ExcelReportService excelService;

    @GetMapping
    public ResponseEntity<byte[]> generateReport() {
        log.info("receiving request to generate a excel report");
        ExcelReportResponseDTO teste = excelService.teste();
        return new ResponseEntity<>(teste.getBytes(), teste.getHttpHeaders(), HttpStatus.OK);
    }
}
