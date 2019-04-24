package edu.uic.group19.a422ndbank.API;

import java.util.ArrayList;

import edu.uic.group19.a422ndbank.Models.Bill;
import edu.uic.group19.a422ndbank.Models.ProfileInfo;
import edu.uic.group19.a422ndbank.Models.TransHistory;

public class Database {

    private ArrayList<TransHistory> transactions;
    private ArrayList<Bill> bills;
    private int amountOfMoney;
    private ProfileInfo profileInfo;

    public Database(ArrayList<TransHistory> transactions, ArrayList<Bill> bills, int amountOfMoney, ProfileInfo profileInfo) {
        this.transactions = transactions;
        this.bills = bills;
        this.amountOfMoney = amountOfMoney;
        this.profileInfo = profileInfo;
    }


    public void payBill(Bill bill) {

    }


    public void addTransaction(TransHistory transaction) {
        transactions.add(transaction);
    }


    public ArrayList<TransHistory> getTransHistories() {
        return transactions;
    }


    public ArrayList<Bill> getBills() {
        return bills;
    }


    public int getAmountOfMoney() {
        return amountOfMoney;
    }


    /**
     * Profile INFO
     */
    public ProfileInfo getProfileInfo() {
        return profileInfo;
    }

    public void updateProfileInfo(ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
    }
}
