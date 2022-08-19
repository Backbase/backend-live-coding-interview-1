package com.backbase.transaction.service;

import com.backbase.transaction.service.impl.BudgetServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BudgetServiceTest {

    private final BudgetService budgetService = new BudgetServiceImpl();

    @Test
    void maxNumberOfItemsToBeBought() {
        Map<String, BigDecimal> itemPriceMap = mockItems();
        int maxNumberOfItemsToBeBought = budgetService.maxNumberOfItemsToBeBought(BigDecimal.valueOf(200), itemPriceMap);
        assertThat(maxNumberOfItemsToBeBought).isEqualTo(7);
    }

    private Map<String, BigDecimal> mockItems() {
        return Map.ofEntries(
                Map.entry("Chair", BigDecimal.valueOf(13)),
                Map.entry("Desk", BigDecimal.valueOf(35)),
                Map.entry("Coffee Table", BigDecimal.valueOf(45)),
                Map.entry("Night Stand", BigDecimal.valueOf(23)),
                Map.entry("Sofa", BigDecimal.valueOf(200)),
                Map.entry("Shoe Rack", BigDecimal.valueOf(25)),
                Map.entry("Drawer", BigDecimal.valueOf(150)),
                Map.entry("Coat Rack", BigDecimal.valueOf(43)),
                Map.entry("Mirror", BigDecimal.valueOf(10)),
                Map.entry("Dining Table", BigDecimal.valueOf(120)),
                Map.entry("Dining Chair", BigDecimal.valueOf(27)));
    }
}