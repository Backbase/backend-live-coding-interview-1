package com.backbase.transaction.service;

import com.backbase.transaction.domain.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface BudgetService {
    int maxNumberOfItemsToBeBought(BigDecimal budget, List<Transaction> transactionList);
}
