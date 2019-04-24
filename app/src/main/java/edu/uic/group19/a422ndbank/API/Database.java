package edu.uic.group19.a422ndbank.API;

import android.util.Pair;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

    private Pair<Integer, Bill> getBillByName(String name) {
        for (int i = 0; i < bills.size(); ++i) {
            if (name.equals(bills.get(i).getName())) {
                return new Pair<>(i, bills.get(i));
            }
        }

        return null;
    }

    public void payBill(String name, int amount) {

        Pair<Integer, Bill> bill = getBillByName(name);
        if (bill == null || amount <= 0) {
            return;
        }

        if (amount >= bill.second.getAmountDue()) {
            bills.remove(bill.first.intValue());
        }
        else {
            int amountStillDue = bill.second.getAmountDue() - amount;
            bill.second.setAmountDue(amountStillDue);
        }

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        String formattedDate = df.format(c);

        TransHistory transHistory = new TransHistory(TransHistory.TransHistoryType.Mobile, -amount, formattedDate);
        transactions.add(transHistory);
        amountOfMoney = amountOfMoney - amount;
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
