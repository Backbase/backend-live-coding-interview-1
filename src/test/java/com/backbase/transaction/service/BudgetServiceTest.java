package com.backbase.transaction.service;

import com.backbase.transaction.domain.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static com.backbase.transaction.service.TestUtils.readTransactions;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BudgetServiceTest {

    private final Resource transactionMockFile = new ClassPathResource("lisa-transactions.json");
    @Autowired
    private BudgetService budgetService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void maxNumberOfItemsToBeBought() throws IOException {
        List<Transaction> transactions = readTransactions(transactionMockFile, objectMapper);
        int maxNumberOfItemsToBeBought = budgetService.maxNumberOfItemsToBeBought(BigDecimal.valueOf(200), transactions);
        assertThat(maxNumberOfItemsToBeBought).isEqualTo(7);
    }
}