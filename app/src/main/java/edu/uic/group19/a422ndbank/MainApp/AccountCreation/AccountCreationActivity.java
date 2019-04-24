package edu.uic.group19.a422ndbank.MainApp.AccountCreation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import edu.uic.group19.a422ndbank.API.Database;
import edu.uic.group19.a422ndbank.MainApp.Global;
import edu.uic.group19.a422ndbank.Models.ProfileInfo;
import edu.uic.group19.a422ndbank.R;

public class AccountCreationActivity extends AppCompatActivity implements SecurityTutorialFragment.OnFragmentInteractionListener, AccountRegisterFragment.OnFragmentInteractionListener {

    private Database database;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_creation);

        FragmentManager fm = getSupportFragmentManager();
        Fragment securityTutorialFragment = new SecurityTutorialFragment();
        fm.beginTransaction().add(R.id.frame_accountCreate, securityTutorialFragment).commit();

    }


    //
    @Override
    protected void onStart() {
        super.onStart();

        database = ((Global) getApplication()).getDatabase();
    }


    //
    @Override
    public void onTutorialEnded() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment accountRegisterFragment = new AccountRegisterFragment();
        fm.beginTransaction().replace(R.id.frame_accountCreate, accountRegisterFragment).commit();
    }


    //
    @Override
    public void onAccountCreated(String firstName, String lastName, String email, String password1, String password2) {

        if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password1.isEmpty() || password2.isEmpty()) {
            Toast.makeText(this, "Please enter all fields.", Toast.LENGTH_SHORT).show();
        } else {
            if(password1.equals(password2)) {
                ProfileInfo profile = new ProfileInfo(firstName, lastName, email, password1);
                database.updateProfileInfo(profile);
                database.reset();
                finish();
            } else {
                Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
