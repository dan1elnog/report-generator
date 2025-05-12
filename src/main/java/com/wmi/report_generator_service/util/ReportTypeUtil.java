package com.wmi.report_generator_service.util;

import com.wmi.report_generator_service.enums.ReportType;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.wmi.report_generator_service.enums.ReportType.*;
import static java.util.Objects.isNull;

@Service
public class ReportTypeUtil {

    private static final Map<ReportType, String> map = Map.of(
            RELATORIO_LAUDO_SEM_IMAGEM, "/reports/laudo-sem-imagens.jrxml",
            RELATORIO_LAUDO_1_IMAGEM, "/reports/laudo-com-uma-imagem.jrxml",
            RELATORIO_LAUDO_1_IMAGEM_DETALHADO, "/reports/laudo-com-1-imagem-detalhado.jrxml",
            RELATORIO_LAUDO_2_IMAGENS, "/reports/laudo-com-duas-imagens.jrxml",
            RELATORIO_LAUDO_3_IMAGENS, "/reports/laudo-com-tres-imagens.jrxml",
            RELATORIO_LAUDO_4_IMAGENS, "/reports/laudo-com-quatro-imagens.jrxml"
    );

    public static String getPathToReportByType(String reportType) {
        if (isNull(reportType)) {
            return map.get(RELATORIO_LAUDO_SEM_IMAGEM);
        }

        return map.get(ReportType.valueOf(reportType));
    }
}
