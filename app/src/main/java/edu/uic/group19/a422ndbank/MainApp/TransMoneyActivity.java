package edu.uic.group19.a422ndbank.MainApp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.uic.group19.a422ndbank.MainApp.DepositeActivity.Depositactivity_upload;
import edu.uic.group19.a422ndbank.Models.TransHistory;
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

        setupKeyboardDismiss(findViewById(R.id.transferParent));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.trans_money_cancel:
                Toast.makeText(this, "Transfer Canceled", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.trans_money_submit:
                doSubmit();
                break;
        }
    }

    public void setupKeyboardDismiss(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(TransMoneyActivity.this);
                    return false;
                }
            });
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    private void doSubmit() {

        if (amountEditText.getText().toString().isEmpty()){
            Toast.makeText(this, "please enter a valid amount", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (phoneNumberEditText.getText().toString().isEmpty()){
            Toast.makeText(this, "please enter a valid phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        ((Global) getApplication()).getDatabase().transferMoney(Integer.parseInt(amountEditText.getText().toString()));
        Toast.makeText(this, "Money Transferred!!", Toast.LENGTH_SHORT).show();

        finish();
    }

    private void initializeAllViews() {
        phoneNumberEditText = findViewById(R.id.trans_money_toPhoneNumEditText);
        amountEditText = findViewById(R.id.trans_money_amountEditText);

        cancelButton = findViewById(R.id.trans_money_cancel);
        submitButton = findViewById(R.id.trans_money_submit);
    }
}
