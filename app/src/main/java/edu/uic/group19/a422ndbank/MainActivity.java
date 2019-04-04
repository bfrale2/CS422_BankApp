package edu.uic.group19.a422ndbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String name = "Mr. Vielle";


    private TextView helloTextView; // main_HelloText

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

        String helloText = "Hello " + name;
        helloTextView.setText(helloText);

        transHistoryButton.setOnClickListener(this);
        depositButton.setOnClickListener(this);
        transMoney.setOnClickListener(this);
        payBillsButton.setOnClickListener(this);
        settingsButton.setOnClickListener(this);
        helpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_TransHist:
                Toast.makeText(this, "Clicked Transaction History", Toast.LENGTH_SHORT).show();

                break;
            case R.id.main_Deposit:
                Toast.makeText(this, "Clicked Deposit", Toast.LENGTH_SHORT).show();

                break;
            case R.id.main_TransMoney:
                Toast.makeText(this, "Clicked Transaction Money", Toast.LENGTH_SHORT).show();

                break;
            case R.id.main_PayBills:
                Toast.makeText(this, "Clicked Pay Bills", Toast.LENGTH_SHORT).show();

                break;
            case R.id.main_Settings:
                Toast.makeText(this, "Clicked Settings", Toast.LENGTH_SHORT).show();

                break;
            case R.id.main_Help:
                Toast.makeText(this, "Clicked Help", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    private void initializeAllViews() {
        helloTextView = findViewById(R.id.main_HelloText);

        transHistoryButton = findViewById(R.id.main_TransHist);
        depositButton = findViewById(R.id.main_Deposit);
        transMoney = findViewById(R.id.main_TransMoney);
        payBillsButton = findViewById(R.id.main_PayBills);
        settingsButton = findViewById(R.id.main_Settings);
        helpButton = findViewById(R.id.main_Help);
    }
}
