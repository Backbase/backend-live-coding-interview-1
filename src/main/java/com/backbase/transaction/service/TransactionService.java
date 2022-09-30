package com.backbase.transaction.service;

import com.backbase.transaction.domain.Transaction;
import com.backbase.transaction.domain.TransactionCategory;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TransactionService {

    Map<TransactionCategory, Set<Transaction>> getCategoryTransactionsMap(List<Transaction> transactions);

    List<Transaction> getTransactionsByAccountId(String accountHolderId);

}
