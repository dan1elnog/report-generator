package com.wmi.report_generator_service.util;

import java.util.List;

public class ConstantsUtil {

    public static final String URL_BUCKET_LOGOS = "https://s3wmilaudos-dev.s3.amazonaws.com/";
    public static final Integer INITIAL_POSITION_EXCEL_HEADER = 6;
    public static final Integer INITIAL_POSITION_EXCEL_BODY = 7;
    public static final Integer TOTAL_COLUMNS_EXCEL_REPORT = 10;

    public static final List<String> EXCEL_REPORT_HEADERS = List.of("Paciente", "Empresa", "Exame", "Indicação",
            "Preço", "Data exame", "Data laudo", "Status", "Data criação exame", "Usuário");

}
