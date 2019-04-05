package edu.uic.group19.a422ndbank.MainApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.uic.group19.a422ndbank.R;

public class TransMoneyActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText phoneNumberEditText, amountEditText;
    private Button cancelButton, submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_money);
        initializeAllViews();
        cancelButton.setOnClickListener(this);
        submitButton.setOnClickListener(this);
        phoneNumberEditText.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.trans_money_cancel:
                finish();
                break;
            case R.id.trans_money_submit:
                doSubmit();
                break;
        }
    }

    private void doSubmit() {
        // TODO implement this
        finish();
    }

    private void initializeAllViews() {
        phoneNumberEditText = findViewById(R.id.trans_money_toPhoneNumEditText);
        amountEditText = findViewById(R.id.trans_money_amountEditText);

        cancelButton = findViewById(R.id.trans_money_cancel);
        submitButton = findViewById(R.id.trans_money_submit);
    }
}
