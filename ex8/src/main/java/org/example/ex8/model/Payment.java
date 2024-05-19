package org.example.ex8.model;

public class Payment {
    private String id;
    private double amount;

    public static Payment of(String id, int amount) {
        var country = new Payment();
            country.setId(id);
            country.setAmount(amount);

        return country;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}
