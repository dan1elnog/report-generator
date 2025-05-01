package com.wmi.report_generator_service.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;

@Getter
@Setter
@Builder
public class ExcelReportResponseDTO {

    private byte[] bytes;
    private HttpHeaders httpHeaders;
}
