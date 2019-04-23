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
