package com.backbase.transaction.service.impl;

import com.backbase.transaction.domain.Transaction;
import com.backbase.transaction.service.BudgetService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Override
    public int maxNumberOfItemsToBeBought(BigDecimal budget, List<Transaction> transactionList) {
        //Implement your solution here
        return 0;
    }

}
