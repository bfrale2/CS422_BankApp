package edu.uic.group19.a422ndbank.MainApp.Settings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.uic.group19.a422ndbank.API.Database;
import edu.uic.group19.a422ndbank.MainApp.Global;
import edu.uic.group19.a422ndbank.Models.ProfileInfo;
import edu.uic.group19.a422ndbank.R;

public class UpdateInfoActivity extends AppCompatActivity {

    private EditText editFirstName;
    private EditText editLastName;
    private EditText editEmail;
    private EditText editPassword1;
    private EditText editPassword2;
    private EditText editConfrimPassword;
    private Button btnUpdate;

    private Database database;


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        editFirstName = findViewById(R.id.field_updateFirstName);
        editLastName = findViewById(R.id.field_updateLastName);
        editEmail = findViewById(R.id.field_updateEmail);
        editPassword1 = findViewById(R.id.field_updatePassword1);
        editPassword2 = findViewById(R.id.field_updatePassword2);
        editConfrimPassword = findViewById(R.id.field_confirmPassword);
        btnUpdate = findViewById(R.id.btn_updateInfo);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfileInfo();
            }
        });
    }


    //
    @Override
    protected void onStart() {
        super.onStart();

        database = ((Global) getApplication()).getDatabase();
        ProfileInfo profile = database.getProfileInfo();

        editFirstName.setText(profile.firstName);
        editLastName.setText(profile.lastName);
        editEmail.setText(profile.email);
    }


    //
    private void updateProfileInfo() {
        ProfileInfo profile = database.getProfileInfo();

        if(editConfrimPassword.getText().toString().equals(profile.password)) {
            if(editPassword1.getText().toString().equals(editPassword2.getText().toString())) {
                String firstName = editFirstName.getText().toString();
                String lastName = editLastName.getText().toString();
                String email = editEmail.getText().toString();

                if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                    Toast.makeText(this, "Account information cannot be blank!", Toast.LENGTH_SHORT).show();
                } else {
                    profile.firstName = firstName;
                    profile.lastName = lastName;
                    profile.email = email;
                    String password = editPassword1.getText().toString();
                    if(!password.isEmpty()) {
                        profile.password = password;
                    }
                    database.updateProfileInfo(profile);
                    Toast.makeText(this, "Account update successful!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "New passwords must match.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Incorrect password.", Toast.LENGTH_SHORT).show();
        }
    }
}
