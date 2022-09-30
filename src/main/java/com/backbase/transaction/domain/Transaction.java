package com.backbase.transaction.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    @Size(min = 1, max = 10)
    private String creditCardAccountNumber;

    @Column
    @NotEmpty
    private String accountHolderId;

    @Column
    @NotNull
    private Double amount;

    @Column
    private String description;

    @Column
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private TransactionCategory transactionCategory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && creditCardAccountNumber == that.creditCardAccountNumber &&
                amount == that.amount && description == that.description &&
                transactionCategory == that.transactionCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creditCardAccountNumber, amount, description, transactionCategory);
    }
}
