package edu.uic.group19.a422ndbank.Models;

public class Bill {

    private String name;
    private int amountDue;

    public Bill(String name, int amountDue) {
        this.name = name;
        this.amountDue = amountDue;
    }

    public String getName() {
        return name;
    }

    public int getAmountDue() {
        return amountDue;
    }
}
