package com.backbase.transaction.service;

import com.backbase.transaction.domain.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUtils {
    public static List<Transaction> readTransactions(Resource file, ObjectMapper objectMapper1) throws IOException {
        List<Transaction> transactions;
        try (InputStream inputStream = file.getInputStream()) {
            transactions = objectMapper1.readValue(inputStream, new TypeReference<>() {
            });
        }
        return transactions;
    }
}
