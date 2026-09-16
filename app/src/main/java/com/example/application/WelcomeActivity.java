package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeActivity extends AppCompatActivity {
    private TextView welcomeText;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcomeText = findViewById(R.id.welcome_text);
        findViewById(R.id.logout_button).setOnClickListener(view -> signOut());

        if (FirebaseApp.getApps(this).isEmpty()) {
            openLogin();
            return;
        }
        auth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = auth == null ? null : auth.getCurrentUser();
        if (user == null) {
            openLogin();
            return;
        }

        if (TextUtils.isEmpty(user.getDisplayName())) {
            welcomeText.setText(R.string.welcome_default);
        } else {
            welcomeText.setText(getString(R.string.welcome, user.getDisplayName()));
        }
    }

    private void signOut() {
        if (auth != null) {
            auth.signOut();
        }
        openLogin();
    }

    private void openLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
