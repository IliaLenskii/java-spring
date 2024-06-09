package org.example.ex10.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private long id;
    private String name;
    private BigDecimal amount;

    public void setName(String name) { this.name = name; }

    public void setId(long id) { this.id = id; }

    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getName() { return name; }

    public BigDecimal getAmount() { return amount; }

    public long getId() { return id; }

    public static Account of() {
        //var country = new Account();
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && Objects.equals(name, account.name) && Objects.equals(amount, account.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amount);
    }
}
