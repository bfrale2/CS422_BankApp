package edu.uic.group19.a422ndbank.MainApp.AccountCreation;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.uic.group19.a422ndbank.R;

public class AccountCreationActivity extends AppCompatActivity implements SecurityTutorialFragment.OnFragmentInteractionListener, AccountRegisterFragment.OnFragmentInteractionListener {


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
    public void onTutorialEnded() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment accountRegisterFragment = new AccountRegisterFragment();
        fm.beginTransaction().replace(R.id.frame_accountCreate, accountRegisterFragment).commit();
    }


    //
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
