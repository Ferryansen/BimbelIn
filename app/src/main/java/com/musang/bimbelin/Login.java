package com.musang.bimbelin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private Button loginButton;
    private EditText textEmail, textPassword;
    private TextView switchRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        loginButton = findViewById(R.id.login_button);
        textEmail = findViewById(R.id.text_email);
        textPassword = findViewById(R.id.text_password);
        switchRegister = findViewById(R.id.switch_register);


        loginButton.setOnClickListener(view -> {
            String email, password;

            email = textEmail.getText().toString();
            password = textPassword.getText().toString();


            if (email.isEmpty()) {
                Toast.makeText(Login.this, "Email should not be empty!", Toast.LENGTH_SHORT).show();
            } else if (!(email.contains("@") && email.endsWith(".com"))) {
                Toast.makeText(Login.this, "Email must contain '@' and ends with '.com'", Toast.LENGTH_SHORT).show();
            } else if (password.isEmpty()) {
                Toast.makeText(Login.this, "Password should not be empty!", Toast.LENGTH_SHORT).show();
            } else {
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, task -> {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(Login.this, MathActivity.class);

                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Login.this, "Cannot proceed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        switchRegister.setOnClickListener(view -> {
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        });
    }

}