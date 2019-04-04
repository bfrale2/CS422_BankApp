package edu.uic.group19.a422ndbank.MainApp.TransHistory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import edu.uic.group19.a422ndbank.Models.TransHistory;
import edu.uic.group19.a422ndbank.R;

public class TransHistoryActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView checkingText;      //  TODO check this for any other checking account number
    private RecyclerView recyclerView;
    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_history);
        initializeAllViews();

        homeButton.setOnClickListener(this);
        configureRecyclerView();
    }

    private void configureRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TransHistoryAdapter adapter = new TransHistoryAdapter(getTransactionHistory());
        recyclerView.setAdapter(adapter);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.trans_hist_homeButton:
                finish();
                break;
        }
    }

    private void initializeAllViews() {
        checkingText = findViewById(R.id.trans_hist_checkingText);
        recyclerView = findViewById(R.id.trans_hist_recyclerview);
        homeButton = findViewById(R.id.trans_hist_homeButton);
    }
}
