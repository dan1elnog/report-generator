package com.wmi.report_generator_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcelReportDTO {

    private String patient;
    private String company;
    private String exam;
    private String indication;
    private String price;
    private String examDate;
    private String medicalReportDate;
    private String status;
    private String examCreationDate;
    private String user;
}
