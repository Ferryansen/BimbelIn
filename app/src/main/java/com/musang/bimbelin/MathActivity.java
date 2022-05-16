package com.musang.bimbelin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.musang.bimbelin.databinding.ActivityMathBinding;

public class MathActivity extends AppCompatActivity {

    ActivityMathBinding binding;
    private TextView signOut, name;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://bimbelin-bae42-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMathBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceScreen(new CounterFragment());
        signOut = findViewById(R.id.sign_out);
        name = findViewById(R.id.user_name);


        databaseReference.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String uID = FirebaseAuth.getInstance().getCurrentUser().getUid();

//                if (snapshot.hasChild(uID)) {
                    String getName = snapshot.child(uID).child("name").getValue(String.class);

                    if (getName.length() > 10) {
                        if (getName.charAt(10) != ' ') {
                            name.setText(getName.substring(0, 10) + "..");
                        } else {
                            name.setText(getName.substring(0, 10));
                        }
                    } else {
                        name.setText(getName);
                    }

//                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        signOut.setOnClickListener(view -> {
            Intent intent = new Intent(MathActivity.this, Login.class);
            startActivity(intent);

            Toast.makeText(MathActivity.this, "Signed out successfully!", Toast.LENGTH_SHORT).show();

            FirebaseAuth.getInstance().signOut();
            finish();
        });

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_counter:
                    replaceScreen(new CounterFragment());
                    break;
                case R.id.nav_area:
                    replaceScreen(new AreaFragment());
                    break;
                case R.id.nav_volume:
                    replaceScreen(new VolumeFragment());
                    break;
            }

            return true;
        });
    }

    private void replaceScreen(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);

        fragmentTransaction.commit();
    }
}