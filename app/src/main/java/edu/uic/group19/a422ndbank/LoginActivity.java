package edu.uic.group19.a422ndbank;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import edu.uic.group19.a422ndbank.API.Database;
import edu.uic.group19.a422ndbank.MainApp.AccountCreation.AccountCreationActivity;
import edu.uic.group19.a422ndbank.MainApp.Global;
import edu.uic.group19.a422ndbank.MainApp.MainActivity;

public class LoginActivity extends AppCompatActivity implements CredentialsFragment.OnFragmentInteractionListener, TwoFactorFragment.OnFragmentInteractionListener {

    LoginProgressFragment loginProgressFragment;
    CredentialsFragment credentialsFragment;
    TwoFactorFragment twoFactorFragment;

    Database database;


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        twoFactorFragment = new TwoFactorFragment();

        FragmentManager fm = getSupportFragmentManager();

        credentialsFragment = new CredentialsFragment();
        fm.beginTransaction().add(R.id.frame_loginStep, credentialsFragment).commit();

        loginProgressFragment = new LoginProgressFragment();
        fm.beginTransaction().add(R.id.frame_loginProgress, loginProgressFragment).commit();
    }


    //
    @Override
    protected void onStart() {
        super.onStart();

        database = ((Global) getApplication()).getDatabase();
    }


    //
    @Override
    public void onCredentialsEntered(String username, String password) {
        String storedEmail = database.getProfileInfo().email;
        String storedPassword = database.getProfileInfo().password;

        if(storedEmail.equals(username) && storedPassword.equals(password)) {

            loginProgressFragment.setProgressCheck(LoginProgressFragment.STEP_CREDNETIALS, true);

            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.frame_loginStep, twoFactorFragment).commit();
        } else {
            Toast.makeText(this, "Incorrect login credentials.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCreateAccount() {
        Intent intent = new Intent(getApplicationContext(), AccountCreationActivity.class);
        startActivity(intent);
    }


    //
    @Override
    public void onTwoFactorChanged(String code) {
        if(code.length() == 6) {
            loginProgressFragment.setProgressCheck(LoginProgressFragment.STEP_TWO_FACTOR, true);
            loginProgressFragment.setLockStatus(false);
            twoFactorFragment.enableSubmit(true);
        } else {
            loginProgressFragment.setProgressCheck(LoginProgressFragment.STEP_TWO_FACTOR, false);
            loginProgressFragment.setLockStatus(true);
            twoFactorFragment.enableSubmit(false);
        }
    }

    @Override
    public void onTwoFactorSubmit(String code) {
        if(code.length() == 6) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }
}
