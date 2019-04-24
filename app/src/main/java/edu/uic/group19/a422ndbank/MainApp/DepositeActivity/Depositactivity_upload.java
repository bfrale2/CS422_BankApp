package edu.uic.group19.a422ndbank.MainApp.DepositeActivity;



import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import edu.uic.group19.a422ndbank.MainApp.Global;
import edu.uic.group19.a422ndbank.Models.TransHistory;
import edu.uic.group19.a422ndbank.R;

public class Depositactivity_upload extends AppCompatActivity {

    Button submitButton;
    EditText amountLbl;
    EditText checkNumber;
    TextView errorLbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.depositupload);

        submitButton = findViewById(R.id.depositSubmitButton);
        amountLbl = findViewById(R.id.enterAmount);
        checkNumber = findViewById(R.id.enterCheckNumber);
        errorLbl = findViewById(R.id.errorLbl);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButtonClicked();
            }
        });

        setupKeyboardDismiss(findViewById(R.id.parent));
    }

    public void setupKeyboardDismiss(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(Depositactivity_upload.this);
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

    private void submitButtonClicked(){
        errorLbl.setText("");
        if (amountLbl.getText().toString().isEmpty()){
            errorLbl.setText("please enter a valid amount");
            return;
        }
        else if (checkNumber.getText().toString().isEmpty()){
            errorLbl.setText("Please enter a valid check number");
            return;
        }

        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        String formattedDate = df.format(c);


        int amount = Integer.valueOf(amountLbl.getText().toString());

        TransHistory transHistory = new TransHistory(TransHistory.TransHistoryType.Deposit, amount, formattedDate);
        ((Global) getApplication()).getDatabase().addTransaction(transHistory);
        Toast.makeText(this, "Check Deposited", Toast.LENGTH_SHORT).show();
        finish();
    }
}
