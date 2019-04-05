package edu.uic.group19.a422ndbank.MainApp.Settings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.uic.group19.a422ndbank.LoginActivity;
import edu.uic.group19.a422ndbank.R;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button updateInfoButton, aboutButton, homeButton, signoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initializeAllViews();

        updateInfoButton.setOnClickListener(this);
        aboutButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
        signoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.settings_updateInfo:
                updateInfo();
                break;

            case R.id.settings_AboutButton:
                about();
                break;

            case R.id.settings_homeButton:
                finish();
                break;

            case R.id.settings_signOutButton:
                signout();
                break;
        }
    }

    private void updateInfo() {
        Toast.makeText(this, "Version 2.0!", Toast.LENGTH_SHORT).show();
    }

    private void about() {
        AboutPopup popup = new AboutPopup(this);
        popup.show();
    }

    private void signout() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        finish();
        startActivity(intent);
    }

    private void initializeAllViews() {
        updateInfoButton = findViewById(R.id.settings_updateInfo);
        aboutButton = findViewById(R.id.settings_AboutButton);
        homeButton = findViewById(R.id.settings_homeButton);
        signoutButton = findViewById(R.id.settings_signOutButton);
    }
}
