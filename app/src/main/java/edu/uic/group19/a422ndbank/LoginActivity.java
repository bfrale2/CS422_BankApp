package edu.uic.group19.a422ndbank;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity implements CredentialsFragment.OnFragmentInteractionListener, LoginProgressFragment.OnFragmentInteractionListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fm = getSupportFragmentManager();

        Fragment credentialsFragment = new CredentialsFragment();
        fm.beginTransaction().add(R.id.frame_loginStep, credentialsFragment).commit();

        Fragment loginProgressFragment = new LoginProgressFragment();
        fm.beginTransaction().add(R.id.frame_loginProgress, loginProgressFragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
