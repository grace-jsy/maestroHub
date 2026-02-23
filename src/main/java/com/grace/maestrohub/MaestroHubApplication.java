package com.grace.maestrohub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MaestroHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaestroHubApplication.class, args);
    }

}
