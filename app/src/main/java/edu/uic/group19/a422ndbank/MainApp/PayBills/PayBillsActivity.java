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

    public static final String TAG = "ttt";
    private RecyclerView recyclerView;
    private TextView amountDueTextView;
    private Button submitButton;
    private PayBillsAdapter adapter;

    private Database database;
    private ArrayList<Bill> bills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bills);
        initializeAllViews();
        submitButton.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        database = ((Global) getApplication()).getDatabase();
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
        adapter = new PayBillsAdapter(bills);
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

    private ArrayList<PayBillsAdapter.PayBillHolder> getBillsFromRecyclerviewCells() {
        ArrayList<PayBillsAdapter.PayBillHolder> list = new ArrayList<>();
        for (int i = 0; i < recyclerView.getLayoutManager().getChildCount(); ++i) {
            PayBillsAdapter.PayBillHolder holder = (PayBillsAdapter.PayBillHolder) recyclerView.findViewHolderForAdapterPosition(i);
            list.add(holder);
        }

        return list;
    }

    private void doSubmit() {
        ArrayList<PayBillsAdapter.PayBillHolder> cells = getBillsFromRecyclerviewCells();

        for(int i = 0; i < cells.size(); ++i){
            String nameOfBill = cells.get(i).getBillName().getText().toString().trim();

            Bill bill = getBillByName(nameOfBill);
            if (bill == null) {
                continue;
            }

            int amountPaid;
            String amountPaidText = cells.get(i).getEditText().getText().toString().trim();
            if (amountPaidText.isEmpty()) {
                amountPaid = 0;
            }
            else {
                amountPaid = Integer.valueOf(amountPaidText);
            }
            database.payBill(bill.getName(), amountPaid);
        }

        configureAmountDue();
        adapter.reloadWith(database.getBills());
    }

    private Bill getBillByName(String name) {
        for (Bill b : bills) {
            if (name.equals(b.getName())) {
                return b;
            }
        }

        return null;
    }

    private void initializeAllViews() {
        recyclerView = findViewById(R.id.pay_bills_recyclerView);
        amountDueTextView = findViewById(R.id.pay_bills_totalAmountDue);
        submitButton = findViewById(R.id.pay_bills_submit);
    }
}
