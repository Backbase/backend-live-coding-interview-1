package com.backbase.transaction.service;

import com.backbase.transaction.domain.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static List<Transaction> readTransactions(String classPathFile)
        throws IOException {
        Resource file = new ClassPathResource(classPathFile);
        List<Transaction> transactions;
        try (InputStream inputStream = file.getInputStream()) {
            transactions = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        }
        return transactions;
    }
}
