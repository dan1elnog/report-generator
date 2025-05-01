package com.wmi.gerador_de_relatorios_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/relatorio-excel")
public class RelatorioExcelController {

    @GetMapping
    public ResponseEntity<String> gerarRelatorio() {
        log.info("recebendo requisição para gerar um relatório excel");
        return ResponseEntity.ok("Olá mundo");
    }
}
