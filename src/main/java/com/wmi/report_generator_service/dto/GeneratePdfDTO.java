package com.wmi.report_generator_service.dto;

import lombok.Data;

@Data
public class GeneratePdfDTO {

    private String reportName;
    private PdfReportDTO pdfReportDTO;
    private String reportType;
}
