package com.backbase.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TransactionManagerApplication {
    public static void main(final String[] args) {
        SpringApplication.run(TransactionManagerApplication.class, args);
    }
}
