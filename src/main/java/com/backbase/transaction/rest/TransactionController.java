package com.backbase.transaction.rest;

import com.backbase.transaction.domain.Transaction;
import com.backbase.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/transaction")
    ResponseEntity<List<Transaction>> getTransactions(@RequestParam @NotEmpty String accountHolderId) {
        return ResponseEntity.ok(transactionService.getTransactionsByAccountId(accountHolderId));
    }

}
