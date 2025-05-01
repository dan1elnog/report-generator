package com.wmi.report_generator_service.service;

import com.wmi.report_generator_service.controller.response.ExcelReportResponseDTO;
import com.wmi.report_generator_service.dto.RegistroDTO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;

@Service
public class ExcelReportService {

    public ExcelReportResponseDTO teste() {
        try(Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("planilha");
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);

            //cabecalho
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Id");
            header.createCell(1).setCellValue("Nome");
            header.createCell(2).setCellValue("Email");

            List<RegistroDTO> usuarios = List.of(
                    new RegistroDTO("1", "João", "joao@email.com"),
                    new RegistroDTO("2", "Maria", "maria@email.com")
            );

            // Populando as linhas
            int rowIdx = 1;
            for (RegistroDTO user : usuarios) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getNome());
                row.createCell(2).setCellValue(user.getEmail());
            }

            // Escreve o Excel em memória (sem salvar em disco)
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            byte[] bytes = out.toByteArray();

            // Prepara o response HTTP com os headers corretos
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(APPLICATION_OCTET_STREAM);
            headers.setContentDisposition(ContentDisposition
                    .attachment()
                    .filename("usuarios.xlsx")
                    .build());

            return ExcelReportResponseDTO.builder().bytes(bytes).httpHeaders(headers).build();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
