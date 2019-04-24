package edu.uic.group19.a422ndbank.MainApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.uic.group19.a422ndbank.API.Database;
import edu.uic.group19.a422ndbank.MainApp.DepositeActivity.DepositActivity;
import edu.uic.group19.a422ndbank.MainApp.HelpPage.HelpActivity;
import edu.uic.group19.a422ndbank.MainApp.PayBills.PayBillsActivity;
import edu.uic.group19.a422ndbank.MainApp.Settings.SettingsActivity;
import edu.uic.group19.a422ndbank.MainApp.TransHistory.TransHistoryActivity;
import edu.uic.group19.a422ndbank.Models.ProfileInfo;
import edu.uic.group19.a422ndbank.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView helloTextView;
    private TextView bankBalanceTextView;

    private Button transHistoryButton;
    private Button depositButton;
    private Button transMoney;
    private Button payBillsButton;
    private Button settingsButton;
    private Button helpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeAllViews();
        transHistoryButton.setOnClickListener(this);
        depositButton.setOnClickListener(this);
        transMoney.setOnClickListener(this);
        payBillsButton.setOnClickListener(this);
        settingsButton.setOnClickListener(this);
        helpButton.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Database database = ((Global) getApplication()).getDatabase();
        ProfileInfo profileInfo = database.getProfileInfo();
        int amount = database.getAmountOfMoney();

        String helloText = "Hello " + profileInfo.firstName + " " + profileInfo.lastName;
        String amountOfMoney = "$" + amount;

        helloTextView.setText(helloText);
        bankBalanceTextView.setText(amountOfMoney);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_TransHist:
                startActivity(new Intent(this, TransHistoryActivity.class));

                break;
            case R.id.main_Deposit:
                startActivity(new Intent(this, DepositActivity.class));

                break;
            case R.id.main_TransMoney:
                startActivity(new Intent(this, TransMoneyActivity.class));

                break;
            case R.id.main_PayBills:
                startActivity(new Intent(this, PayBillsActivity.class));

                break;
            case R.id.main_Settings:
                startActivity(new Intent(this, SettingsActivity.class));

                break;
            case R.id.main_Help:
                startActivity(new Intent(this, HelpActivity.class));

                break;
        }
    }

    private void initializeAllViews() {
        helloTextView = findViewById(R.id.main_HelloText);
        bankBalanceTextView = findViewById(R.id.main_BankBalance);
        transHistoryButton = findViewById(R.id.main_TransHist);
        depositButton = findViewById(R.id.main_Deposit);
        transMoney = findViewById(R.id.main_TransMoney);
        payBillsButton = findViewById(R.id.main_PayBills);
        settingsButton = findViewById(R.id.main_Settings);
        helpButton = findViewById(R.id.main_Help);
    }
}
