package com.wmi.report_generator_service.util;

import com.wmi.report_generator_service.controller.response.ExcelReportResponseDTO;
import com.wmi.report_generator_service.dto.ExcelReportDTO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.wmi.report_generator_service.util.ConstantsUtil.*;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;

@Service
public class ExcelUtil {

    public ExcelReportResponseDTO generateExcel(List<String> columnNames, List<ExcelReportDTO> values) {
        try(Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("planilha");
            generateHeader(workbook, sheet, columnNames);
            generateCellValues(sheet, values);

            generateLogoImage(workbook, sheet);


            return generateExcelResponseDTO(workbook);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static ExcelReportResponseDTO generateExcelResponseDTO(Workbook workbook) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        byte[] bytes = out.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.attachment().filename("usuarios.xlsx").build());

        return ExcelReportResponseDTO.builder().bytes(bytes).httpHeaders(headers).build();
    }

    private void generateLogoImage(Workbook workbook, Sheet sheet) throws IOException {
        InputStream is = new FileInputStream("src/main/java/com/wmi/report_generator_service/asset/img.png");
        byte[] image = IOUtils.toByteArray(is);
        is.close();

        int pictureIdx = workbook.addPicture(image, Workbook.PICTURE_TYPE_PNG);
        CreationHelper helper = workbook.getCreationHelper();
        Drawing<?> drawing = sheet.createDrawingPatriarch();

        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(0); // coluna onde começa
        anchor.setRow1(0); // linha onde começa

        Picture pict = drawing.createPicture(anchor, pictureIdx);
        pict.resize();
    }

    private void generateHeader(Workbook workbook, Sheet sheet, List<String> names){
        Font font = workbook.createFont();
        font.setBold(true);

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);

        Row header = sheet.createRow(INITIAL_POSITION_EXCEL_HEADER);
        int index = 0;

        List<Integer> cellSizes= new ArrayList<>();

        for (String name : names) {
            Cell cell = header.createCell(index);
            cell.setCellValue(name);
            cell.setCellStyle(cellStyle);
            cellSizes.add(name.length());
            index++;
        }

        int qtdColumns = sheet.getRow(INITIAL_POSITION_EXCEL_HEADER).getPhysicalNumberOfCells();
        for(int i = 0; i < qtdColumns; i++ ) {
            int currentMax = cellSizes.get(i);
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    Cell cell = row.getCell(i);
                    if (cell != null && cell.getCellType() == CellType.STRING) {
                        int length = cell.getStringCellValue().length();
                        currentMax = Math.max(currentMax, length);
                    }
                }
            }
            sheet.setColumnWidth(i, (currentMax + 2) * 256);
        }
    }

    private void generateCellValues(Sheet sheet, List<ExcelReportDTO> values){
        int rowIdx = INITIAL_POSITION_EXCEL_BODY;
        int totalColumns = TOTAL_COLUMNS_EXCEL_REPORT;
        List<Integer> cellSizes = new ArrayList<>(Collections.nCopies(totalColumns, 0));

        for (ExcelReportDTO value : values) {
            Row row = sheet.createRow(rowIdx++);
            String[] fields = {
                    value.getPatient(),
                    value.getCompany(),
                    value.getExam(),
                    value.getIndication(),
                    value.getPrice(),
                    value.getExamDate(),
                    value.getMedicalReportDate(),
                    value.getStatus(),
                    value.getExamCreationDate(),
                    value.getUser()
            };

            for (int col = 0; col < totalColumns; col++) {
                String text = fields[col] != null ? fields[col] : "-";
                row.createCell(col).setCellValue(text);

                int actualSize = cellSizes.get(col);
                cellSizes.set(col, Math.max(actualSize, text.length()));
            }
        }

        // Ajustar largura das colunas com margem extra
        for (int i = 0; i < totalColumns; i++) {
            sheet.setColumnWidth(i, (cellSizes.get(i) + 10) * 256);
        }
    }
}
