package com.wmi.report_generator_service.util;

import com.wmi.report_generator_service.dto.ExcelReportDTO;

import java.util.List;

public class ConstantsUtil {

    public static final Integer INITIAL_POSITION_EXCEL_HEADER = 6;
    public static final Integer INITIAL_POSITION_EXCEL_BODY = 7;
    public static final Integer TOTAL_COLUMNS_EXCEL_REPORT = 10;

    public static final List<String> EXCEL_REPORT_HEADERS = List.of("Paciente", "Empresa", "Exame", "Indicação",
            "Preço", "Data exame", "Data laudo", "Status", "Data criação exame", "Usuário");

    public static final List<ExcelReportDTO> EXCEL_REPORT_MOCK = List.of(
            new ExcelReportDTO("ADEILSON ADELE", "BRASIL MADEIRAS PARANA EIRELI BRASIL MADEIRAS PARANA EIRELI BRASIL MADEIRAS PARANA EIRELI", "Eletrocardiograma", "Indicação", "4,5", "03-04-2025", "10-04-2025 15:54", "LAUDADO", "10-04-2025 10:40", "ESPAÇO SST ARAPONGAS"),
            new ExcelReportDTO("ADEILSON", "BRASIL MADEIRAS PARANA EIRELI", "Eletrocardiograma", "Indicação", "4,5", "03-04-2025", "10-04-2025 15:54", "LAUDADO", "10-04-2025 10:40", "ESPAÇO SST ARAPONGAS"),
            new ExcelReportDTO("ADEILSON", "BRASIL MADEIRAS PARANA EIRELI", null, "Indicação", "4,5", "03-04-2025", "10-04-2025 15:54", "LAUDADO", "10-04-2025 10:40", "ESPAÇO SST ARAPONGAS"),
            new ExcelReportDTO("ADEILSON", "BRASIL MADEIRAS PARANA EIRELI", "Eletrocardiograma", "Indicação", "4,5", "03-04-2025", "10-04-2025 15:54", "LAUDADO", "10-04-2025 10:40", "ESPAÇO SST ARAPONGAS"),
            new ExcelReportDTO("ADEILSON", "BRASIL MADEIRAS PARANA EIRELI", "Eletrocardiograma", "Indicação", "4,5", "03-04-2025", "10-04-2025 15:54", "LAUDADO", "10-04-2025 10:40", "ESPAÇO SST ARAPONGAS")
    );
}
