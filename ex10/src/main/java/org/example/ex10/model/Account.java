package org.example.ex10.model;

import java.math.BigDecimal;

public class Account {
    private long id;
    private String name;
    private BigDecimal amount;

    public void setName(String name) { this.name = name; }

    public void setId(long id) { this.id = id; }

    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getName() { return name; }

    public BigDecimal getAmount() { return amount; }

    public static Account of() {
        //var country = new Account();
        return null;
    }
}
