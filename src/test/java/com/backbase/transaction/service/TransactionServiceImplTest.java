package com.backbase.transaction.service;

import static com.backbase.transaction.service.TestUtils.readTransactions;
import static org.assertj.core.api.Assertions.assertThat;

import com.backbase.transaction.domain.Transaction;
import com.backbase.transaction.domain.TransactionCategory;
import com.backbase.transaction.repository.TransactionRepository;
import com.backbase.transaction.service.impl.TransactionServiceImpl;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @Mock
    private TransactionRepository dependency;

    private TransactionServiceImpl target = new TransactionServiceImpl(dependency);

    @Test
    void categorizeTransactions() throws IOException {
        List<Transaction> transactions = readTransactions("transactions.json");
        Map<TransactionCategory, Set<Transaction>> categoryTransactionsMap =
            target.getCategoryTransactionsMap(transactions);
        assertThat(categoryTransactionsMap).isNotEmpty();
        assertThat(categoryTransactionsMap.get(TransactionCategory.FOOD)).hasSize(2);
        assertThat(categoryTransactionsMap.get(TransactionCategory.TRAVEL)).hasSize(1);
        assertThat(categoryTransactionsMap.get(TransactionCategory.TRANSPORTATION)).hasSize(1);
        assertThat(categoryTransactionsMap.get(TransactionCategory.SHOPPING)).hasSize(3);
        assertThat(categoryTransactionsMap.get(TransactionCategory.LEISURE)).hasSize(1);
    }
}
