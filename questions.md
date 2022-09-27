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
in [BudgetServiceSimple](src/main/java/com/backbase/transaction/service/impl/BudgetServiceSimple.java) class

P.S.: Budged and prices are left integer on purpose. So candidate can focus on solving the problem. If they don’t realize or don’t mention the problem it’s ok but if they do it’s a bonus point.”


Solution:

    public int maxNumberOfItemsToBeBought(Integer budget, Map<String, Integer> itemMap) {
        //Implement your solution here
        List<Integer> prices = itemMap.values().stream().filter(a->a<=budget).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        int sum = 0;
        int itemCount = 0;
        for (int i : prices) {
            sum += i;
            if (sum > budget) {
                break;
            }
            itemCount++;
        }
        return itemCount;
    }

(Did they use functional programming, streams etc? If not encourage them to use and see how they perform.)

Followup question can be about the lazy evaluation of Streams.


What is the time and space complexity of the solution. (If it is not an optimum one, give them some hints and ask again, make them compare solutions. that's how we decide which approach are we going to use after all.)

time complexity: O(n log n)

space complexity: O(n)

(If they didn't already mention about Bigdecimal):

If we use double instead of integer, would this solution still be working correctly? What would be the real world approach for money calculations?

Should we handle any possible exceptions?



What would be the result of the code sample below, how? why?  Tell me about String being immutable.

        String first = "aa";
        String second = "aa";

        System.out.println(first == second);

How hashmap works in java(what do hashCode(), equals() methods do? Can we use non-immutable key? Why is it important to have immutable key. What would happen if we use non-immutable key?)

As a second part :

If you have been given a task to write this code as a REST API how would your design be? Which HTTP verb would you use?(Expecting them to explain what would controller,service layers be like and the design of URI considering Richardson maturity model)
(Expecting something similar to this: GET: /budgets/max-items?budget=234123)

Now let's make it a little bit more complex by adding shop informations. Let's say there are 5 shops and every shop has different items and prices. How would be the URI design for:

- Shopping from all of them (GET: /budgets/max-items?budget=123123).
- Shopping from one specific shop (GET: /budgets/shop/{shopId}/max-items?budget=123123).

(Considering the remaining time, if we think there is enough time, we can ask them to implement the controller too)

In [BudgetServiceImpl](src/main/java/com/backbase/transaction/service/impl/BudgetServiceImpl.java) class we implemented an interface and not extended from some abstract class. Considering OOP, how do you decide when to extend from an abstract class and when to implement from an interface(expecting them to be able to explain is a(extending from abstract class), has a(implementing from an interface) relationship)






Lisa has recently moved to her new apartment. She has bought some furniture and made some transactions in her account.
She found out that she needs to pay for her college, and she doesn't have enough money, so she should return a few
pieces the furniture.
Given the transaction list can you please calculate the max number of items she can keep?
Note: She paid for each item separately (each transaction is for 1 piece of furniture)
Implement your solution
in [BudgetServiceImpl](src/main/java/com/backbase/transaction/service/impl/BudgetServiceImpl.java) class