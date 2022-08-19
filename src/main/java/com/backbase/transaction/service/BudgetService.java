package com.backbase.transaction.service;

import java.math.BigDecimal;
import java.util.Map;

public interface BudgetService {
    int maxNumberOfItemsToBeBought(BigDecimal budget, Map<String, BigDecimal> itemMap);
}
