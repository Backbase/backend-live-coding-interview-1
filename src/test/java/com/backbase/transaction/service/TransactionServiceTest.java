package com.backbase.transaction.service;

import com.backbase.transaction.domain.Transaction;
import com.backbase.transaction.domain.TransactionCategory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TransactionServiceTest {

    private final Resource transactionMockFile = new ClassPathResource("transactions.json");
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private TransactionService transactionService;

    @Test
    void categorizeTransactions() throws IOException {
        List<Transaction> transactions;
        try (InputStream inputStream = transactionMockFile.getInputStream()) {
            transactions = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        }
        Map<TransactionCategory, Set<Transaction>> categoryTransactionsMap =
                transactionService.getCategoryTransactionsMap(transactions);
        assertThat(categoryTransactionsMap).isNotEmpty();
        assertThat(categoryTransactionsMap.get(TransactionCategory.FOOD)).hasSize(2);
        assertThat(categoryTransactionsMap.get(TransactionCategory.TRAVEL)).hasSize(1);
        assertThat(categoryTransactionsMap.get(TransactionCategory.TRANSPORTATION)).hasSize(1);
        assertThat(categoryTransactionsMap.get(TransactionCategory.SHOPPING)).hasSize(3);
        assertThat(categoryTransactionsMap.get(TransactionCategory.LEISURE)).hasSize(1);
    }
}
