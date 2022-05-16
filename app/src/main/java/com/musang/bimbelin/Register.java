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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.musang.bimbelin.user.DataInfo;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private TextView switchLogin;
    private EditText textBimbel, textEmail, textName, textPassword, textConPassword;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        switchLogin = findViewById(R.id.switch_login);
        register = findViewById(R.id.register_button);
        textBimbel = findViewById(R.id.text_bimbel_id);
        textEmail = findViewById(R.id.text_email);
        textName = findViewById(R.id.text_name);
        textPassword = findViewById(R.id.password);
        textConPassword = findViewById(R.id.confirm_password);


        register.setOnClickListener(view -> {
            String email, password, conPassword, bimbelID, name;

            email = textEmail.getText().toString();
            password = textPassword.getText().toString();
            bimbelID = textBimbel.getText().toString();
            name = textName.getText().toString();
            conPassword = textConPassword.getText().toString();


            if (bimbelID.isEmpty()) {
                Toast.makeText(Register.this, "Bimbel ID should not be empty!", Toast.LENGTH_SHORT).show();
            } else if (email.isEmpty()) {
                Toast.makeText(Register.this, "Email should not be empty!", Toast.LENGTH_SHORT).show();
            } else if (!(email.contains("@") && email.endsWith(".com"))) {
                Toast.makeText(Register.this, "Email must contain '@' and ends with '.com'", Toast.LENGTH_SHORT).show();
            } else if (name.isEmpty()) {
                Toast.makeText(Register.this, "Your name should not be empty!", Toast.LENGTH_SHORT).show();
            } else if (name.length() < 5) {
                Toast.makeText(Register.this, "Name length must be at least 5 characters", Toast.LENGTH_SHORT).show();
            } else if (password.isEmpty()) {
                Toast.makeText(Register.this, "Password should not be empty!", Toast.LENGTH_SHORT).show();
            } else if (conPassword.isEmpty()) {
                Toast.makeText(Register.this, "Confirm password should not be empty!", Toast.LENGTH_SHORT).show();
            } else if (!(conPassword.equals(password))) {
                Toast.makeText(Register.this, "Password and confirm password is not the same", Toast.LENGTH_SHORT).show();
            } else {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Register.this, task -> {
                            if (task.isSuccessful()) {
                                String uID = FirebaseAuth.getInstance().getCurrentUser().getUid();

                                Toast.makeText(Register.this, "Account Registered", Toast.LENGTH_LONG).show();

                                DataInfo dataInfo = new DataInfo(bimbelID, name);
                                mDatabase.child("Users").child(uID).setValue(dataInfo);


                                onBackPressed();
                            } else {
                                Toast.makeText(Register.this, "Cannot proceed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        switchLogin.setOnClickListener(view -> {
            onBackPressed();
        });
    }
}