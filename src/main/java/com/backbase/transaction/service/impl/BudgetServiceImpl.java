package com.backbase.transaction.service.impl;

import com.backbase.transaction.service.BudgetService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Override
    public int maxNumberOfItemsToBeBought(BigDecimal budget, Map<String, BigDecimal> itemMap) {
        //Implement your solution here
        List<BigDecimal> prices = itemMap.values().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        BigDecimal sum = BigDecimal.ZERO;
        int numberOfItems = 0;
        for (BigDecimal price : prices) {
            BigDecimal newSum = sum.add(price);
            if (newSum.compareTo(budget) > 0) {
                break;
            }
            sum = newSum;
            numberOfItems += 1;
        }
        return numberOfItems;
    }

}
