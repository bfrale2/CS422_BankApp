package edu.uic.group19.a422ndbank.MainApp;

import android.app.Application;

import java.util.ArrayList;

import edu.uic.group19.a422ndbank.API.Database;
import edu.uic.group19.a422ndbank.Models.Bill;
import edu.uic.group19.a422ndbank.Models.ProfileInfo;
import edu.uic.group19.a422ndbank.Models.TransHistory;

public class Global extends Application {

    private Database database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = new Database(
                getTransactionHistory(),
                getBills(),
                15000,
                getProfileInfo()
        );
    }

    private ProfileInfo getProfileInfo() {
        return new ProfileInfo("Fred", "Vielle", "email@email.com");
    }

    private ArrayList<TransHistory> getTransactionHistory() {
        ArrayList<TransHistory> history = new ArrayList<>();
        history.add(new TransHistory(TransHistory.TransHistoryType.BalanceTransfer, 200, "3/2/2018"));
        history.add(new TransHistory(TransHistory.TransHistoryType.Mobile, -100, "3/8/2018"));
        history.add(new TransHistory(TransHistory.TransHistoryType.Deposit, 500, "3/12/2018"));
        history.add(new TransHistory(TransHistory.TransHistoryType.Deposit, 200, "3/22/2018"));
        history.add(new TransHistory(TransHistory.TransHistoryType.Mobile, -60, "3/25/2018"));
        history.add(new TransHistory(TransHistory.TransHistoryType.Mobile, -120, "3/29/2018"));
        return history;
    }

    private ArrayList<Bill> getBills() {
        ArrayList<Bill> bills = new ArrayList<>();
        bills.add(new Bill("Comcast", 80));
        bills.add(new Bill("AT&T", 20));
        bills.add(new Bill("Cricket", 10));
        bills.add(new Bill("Xsport", 35));
        return bills;
    }

    public Database getDatabase() {
        return database;
    }
}
