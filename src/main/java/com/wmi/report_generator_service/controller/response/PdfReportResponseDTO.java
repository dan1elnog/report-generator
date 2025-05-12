package com.wmi.report_generator_service.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PdfReportResponseDTO {

    private byte[] pdf;
    private String reportName;
}
