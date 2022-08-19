# [pom.xml](pom.xml)

1. There is a mistake in the dependencyManagement/dependency sections, what is it?

# [TransactionServiceImpl.java](src/main/java/com/backbase/transaction/service/impl/TransactionServiceImpl.java)

1. There's a mistake in `getEmptyOptionalTransaction` method. can you find it?
2. Implement `getCategoryTransactionsMap()` method to make the tests pass.

# [Transaction.java](src/main/java/com/backbase/transaction/domain/Transaction.java)

1. Take a look at `transactionCategory` field. Do you notice any issues?
2. Do you notice any other issues with the other field types?

# [TransactionRepository](src/main/java/com/backbase/transaction/repository/TransactionRepository.java)

1. Is the query going to perform well for a large number of Transaction? How can we make sure it does?

# Security Question

1. The security department said
   that [TransactionController](src/main/java/com/backbase/transaction/rest/TransactionController.java) has security
   vulnerabilities, can you spot them and
   suggest fixes? (take a look at `TokenSecurityUtils.getCurrentUser()`)

# Algorithm

Lisa has recently moved to a new apartment. She has a budget to buy new furniture for her house.<br>
Given the items of furniture and their corresponding prices, please calculate the maximum number of furniture items she
can buy.
Note: She only needs one of each item.
Implement your solution
in [BudgetServiceImpl](src/main/java/com/backbase/transaction/service/impl/BudgetServiceImpl.java) class