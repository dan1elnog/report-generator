package com.wmi.report_generator_service.controller.request;

import lombok.Getter;

@Getter
public class GenerateExcelReportRequestDTO {

    private Long invoiceId;
    private Long partnerId;
}
