package com.cakal.cloud.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@SpringBootApplication(scanBasePackages = {"com.cakal.cloud.es"})
@EntityScan(basePackages = {"com.cakal.cloud.es.model"})
@EnableTransactionManagement(proxyTargetClass = true)
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

}
