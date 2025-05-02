package com.wmi.report_generator_service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class GenerateExcelDTO {

    private String logo;
    private List<ExcelReportDTO> values;
    private List<String> columnNames;
    private String reportName;
}
