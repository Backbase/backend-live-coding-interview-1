# Transaction Service

This is a spring application which persists financial transactions (like when you buy something in the store and pay it
using your card) for the bank customers. <br>
It uses maven, spring-boot and spring-web.<br>
It has one [REST controller](src/main/java/com/backbase/transaction/rest/TransactionController.java) and one endpoint
for retrieving the customer's transactions using the `accountHolderId`.<br>
It uses a JpaRepository to query the H2 database.

# Compile and test

You can use this command to build the and test the project:<br>
`mvn clean install`