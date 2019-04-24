package edu.uic.group19.a422ndbank.MainApp.PayBills;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import edu.uic.group19.a422ndbank.API.Database;
import edu.uic.group19.a422ndbank.MainApp.Global;
import edu.uic.group19.a422ndbank.Models.Bill;
import edu.uic.group19.a422ndbank.R;

public class PayBillsActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private TextView amountDueTextView;
    private Button submitButton;

    private ArrayList<Bill> bills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bills);
        initializeAllViews();
        submitButton.setOnClickListener(this);
        Database database = ((Global) getApplication()).getDatabase();
        bills = database.getBills();
        configureRecyclerView();
        configureAmountDue();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pay_bills_submit:
                doSubmit();
                break;
        }
    }

    private void configureRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        PayBillsAdapter adapter = new PayBillsAdapter(bills);
        recyclerView.setAdapter(adapter);
    }

    private void configureAmountDue() {
        int sum = 0;
        for (Bill bill : bills) {
            sum += bill.getAmountDue();
        }
        String amountDue = "$" + sum;
        amountDueTextView.setText(amountDue);
    }

    private void doSubmit() {
        finish();
    }

    private void initializeAllViews() {
        recyclerView = findViewById(R.id.pay_bills_recyclerView);
        amountDueTextView = findViewById(R.id.pay_bills_totalAmountDue);
        submitButton = findViewById(R.id.pay_bills_submit);
    }
}
