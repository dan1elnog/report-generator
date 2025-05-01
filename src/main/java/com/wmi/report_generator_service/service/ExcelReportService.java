package com.wmi.report_generator_service.service;

import com.wmi.report_generator_service.controller.response.ExcelReportResponseDTO;
import com.wmi.report_generator_service.util.ExcelUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.wmi.report_generator_service.util.ConstantsUtil.EXCEL_REPORT_HEADERS;
import static com.wmi.report_generator_service.util.ConstantsUtil.EXCEL_REPORT_MOCK;

@Service
@RequiredArgsConstructor
public class ExcelReportService {

    private final ExcelUtil excelUtil;

    public ExcelReportResponseDTO teste() {
        return excelUtil.generateExcel(EXCEL_REPORT_HEADERS, EXCEL_REPORT_MOCK);
    }
}
