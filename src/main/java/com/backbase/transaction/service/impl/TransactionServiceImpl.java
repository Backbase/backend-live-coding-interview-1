package com.backbase.transaction.service.impl;

import com.backbase.transaction.domain.Transaction;
import com.backbase.transaction.domain.TransactionCategory;
import com.backbase.transaction.repository.TransactionRepository;
import com.backbase.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Map<TransactionCategory, Set<Transaction>> getCategoryTransactionsMap(List<Transaction> transactions) {
        //Implement here
        return null;
    }

    public Optional<Transaction> getEmptyOptionalTransaction() {
        Transaction transaction = null;
        return Optional.of(transaction);
    }

    @Override
    public List<Transaction> getTransactionsByAccountId(String accountHolderId) {
        return transactionRepository.findAllByAccountHolderId(accountHolderId);
    }
}
