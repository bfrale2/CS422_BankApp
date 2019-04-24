package edu.uic.group19.a422ndbank.MainApp.DepositeActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.uic.group19.a422ndbank.MainApp.HelpPage.HelpActivity;
import edu.uic.group19.a422ndbank.R;

public class DepositActivity extends AppCompatActivity implements View.OnClickListener {

    private Button check_deposit;
    private Button cash_deposit;
    private Button home_button;
    private Button help_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        initializeAllViews();

        check_deposit.setOnClickListener(this);
        cash_deposit.setOnClickListener(this);
        help_button.setOnClickListener(this);
        home_button.setOnClickListener(this);
    }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.check_deposit:
                    depositeCheck();
                    break;

                case R.id.cash_deposit:
                    openDailog();
                    break;

                case R.id.trans_hist_homeButton:
                    finish();
                    break;

                case R.id.help_deposit:
                    goToHelpPage();
                    break;
            }
        }

    public void openDailog() {
        dailogclass exampleDialog = new dailogclass();
        exampleDialog.show(getSupportFragmentManager(), "Information");
    }

    private void depositeCheck(){
        Intent i = new Intent(DepositActivity.this, Depositactivity_upload.class);
        startActivity(i);
    }

    private void goToHelpPage(){
        Intent i = new Intent(DepositActivity.this, HelpActivity.class);
        startActivity(i);
    }

    private void initializeAllViews() {
        check_deposit = findViewById(R.id.check_deposit);
        cash_deposit = findViewById(R.id.cash_deposit);
        home_button = findViewById(R.id.trans_hist_homeButton);
        help_button= findViewById(R.id.help_deposit);

    }
}
