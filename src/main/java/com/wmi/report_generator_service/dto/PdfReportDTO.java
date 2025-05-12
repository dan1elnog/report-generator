package com.wmi.report_generator_service.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
public class PdfReportDTO {

    private String logo;
    private String parceiro;
    private String endereco;
    private String localidade;
    private String telefone;
    private String qrcode;
    private String imagem1;
    private String imagem2;
    private String imagem3;
    private String imagem4;
    private String validador;
    private String especialidade;
    private String variacao;
    private String incidencia;
    private String lado;
    private String paciente;
    private String nascimento;
    private String sexo;
    private String rg;
    private String cpf;
    private String controle;
    private String indicacao;
    private String funcao;
    private String data_exame;
    private String empresa;
    private String laudo;
    private String site;
    private String medico;
    private String matricula;
    private String medicoSolicitante;
    private String tecnicoResponsavel;
    private String data;
    private String hora;
    private String token;
    private String watermark;
    private String carimbo;

    public Map<String, String> getAttributes(){
        Map<String, String> attributes = new HashMap<>();

        Optional.ofNullable(logo).ifPresent(value -> attributes.put("logo", logo));
        Optional.ofNullable(parceiro).ifPresent(value -> attributes.put("parceiro", parceiro));
        Optional.ofNullable(endereco).ifPresent(value -> attributes.put("endereco", endereco));
        Optional.ofNullable(localidade).ifPresent(value -> attributes.put("localidade", localidade));
        Optional.ofNullable(telefone).ifPresent(value -> attributes.put("telefone", telefone));
        Optional.ofNullable(qrcode).ifPresent(value -> attributes.put("qrcode", qrcode));
        Optional.ofNullable(imagem1).ifPresent(value -> attributes.put("imagem_1", imagem1));
        Optional.ofNullable(imagem2).ifPresent(value -> attributes.put("imagem_2", imagem2));
        Optional.ofNullable(imagem3).ifPresent(value -> attributes.put("imagem_3", imagem3));
        Optional.ofNullable(imagem4).ifPresent(value -> attributes.put("imagem_4", imagem4));
        Optional.ofNullable(validador).ifPresent(value -> attributes.put("validador", validador));
        Optional.ofNullable(especialidade).ifPresent(value -> attributes.put("especialidade", especialidade));
        Optional.ofNullable(variacao).ifPresent(value -> attributes.put("variacao", variacao));
        Optional.ofNullable(incidencia).ifPresent(value -> attributes.put("incidencia", incidencia));
        Optional.ofNullable(paciente).ifPresent(value -> attributes.put("paciente", paciente));
        Optional.ofNullable(nascimento).ifPresent(value -> attributes.put("nascimento", nascimento));
        Optional.ofNullable(sexo).ifPresent(value -> attributes.put("sexo", sexo));
        Optional.ofNullable(rg).ifPresent(value -> attributes.put("rg", rg));
        Optional.ofNullable(cpf).ifPresent(value -> attributes.put("cpf", cpf));
        Optional.ofNullable(controle).ifPresent(value -> attributes.put("controle", controle));
        Optional.ofNullable(indicacao).ifPresent(value -> attributes.put("indicacao", indicacao));
        Optional.ofNullable(funcao).ifPresent(value -> attributes.put("funcao", funcao));
        Optional.ofNullable(data_exame).ifPresent(value -> attributes.put("data_exame", data_exame));
        Optional.ofNullable(empresa).ifPresent(value -> attributes.put("empresa", empresa));
        Optional.ofNullable(laudo).ifPresent(value -> attributes.put("laudo", laudo));
        Optional.ofNullable(site).ifPresent(value -> attributes.put("site", site));
        Optional.ofNullable(medico).ifPresent(value -> attributes.put("medico", medico));
        Optional.ofNullable(matricula).ifPresent(value -> attributes.put("matricula", matricula));
        Optional.ofNullable(medicoSolicitante).ifPresent(value -> attributes.put("medico_solicitante", medicoSolicitante));
        Optional.ofNullable(tecnicoResponsavel).ifPresent(value -> attributes.put("tecnico_responsavel", tecnicoResponsavel));
        Optional.ofNullable(data).ifPresent(value -> attributes.put("data", data));
        Optional.ofNullable(hora).ifPresent(value -> attributes.put("hora", hora));
        Optional.ofNullable(token).ifPresent(value -> attributes.put("token", token));
        Optional.ofNullable(watermark).ifPresent(value -> attributes.put("watermark", watermark));
        Optional.ofNullable(carimbo).ifPresent(value -> attributes.put("carimbo", carimbo));

        return attributes;
    }
}
