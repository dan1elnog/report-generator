package com.wmi.report_generator_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.wmi.report_generator_service")
public class ReportGeneratorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportGeneratorServiceApplication.class, args);
    }

}
