package com.wmi.report_generator_service.util;

import com.wmi.report_generator_service.enums.ReportType;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.wmi.report_generator_service.enums.ReportType.RELATORIO_LAUDO_1_IMAGEM;
import static com.wmi.report_generator_service.enums.ReportType.RELATORIO_LAUDO_SEM_IMAGEM;
import static java.util.Objects.isNull;

@Service
public class ReportTypeUtil {

    private static final Map<ReportType, String> map = Map.of(
            RELATORIO_LAUDO_SEM_IMAGEM, "/reports/laudo-raio-x-sem-imagens.jrxml",
            RELATORIO_LAUDO_1_IMAGEM, "/reports/laudo-com-uma-imagem.jrxml"
    );

    public static String getPathToReportByType(String reportType){
        if(isNull(reportType)){
            return map.get(RELATORIO_LAUDO_SEM_IMAGEM);
        }

        return map.get(ReportType.valueOf(reportType));
    }
}
