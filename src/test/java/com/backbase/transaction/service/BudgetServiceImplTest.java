package com.backbase.transaction.service;

import static com.backbase.transaction.service.TestUtils.readTransactions;
import static org.assertj.core.api.Assertions.assertThat;

import com.backbase.transaction.domain.Transaction;
import com.backbase.transaction.service.impl.BudgetServiceImpl;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class BudgetServiceImplTest {

    private BudgetServiceImpl target = new BudgetServiceImpl();

    @Test
    void maxNumberOfItemsToBeBought() throws IOException {
        List<Transaction> transactions = readTransactions("lisa-transactions.json");
        int maxNumberOfItemsToBeBought = target.maxNumberOfItemsToBeBought(BigDecimal.valueOf(200),
            transactions);
        assertThat(maxNumberOfItemsToBeBought).isEqualTo(7);
    }
}
