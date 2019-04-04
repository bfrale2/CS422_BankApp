package edu.uic.group19.a422ndbank;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.uic.group19.a422ndbank.MainApp.MainActivity;

public class LoginActivity extends AppCompatActivity implements CredentialsFragment.OnFragmentInteractionListener, TwoFactorFragment.OnFragmentInteractionListener {

    LoginProgressFragment loginProgressFragment;
    CredentialsFragment credentialsFragment;
    TwoFactorFragment twoFactorFragment;


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
    public void onCredentialsEntered(String username, String password) {
        if(!username.isEmpty() && !password.isEmpty()) {

            loginProgressFragment.setProgressCheck(LoginProgressFragment.STEP_CREDNETIALS, true);

            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.frame_loginStep, twoFactorFragment).commit();
        }
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
