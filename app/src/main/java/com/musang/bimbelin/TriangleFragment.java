package com.musang.bimbelin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TriangleFragment extends Fragment {

    private EditText base, height;
    private Button equal;
    private TextView calculation;

    public TriangleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_triangle, container, false);

        base = view.findViewById(R.id.triangle_base);
        height = view.findViewById(R.id.triangle_height);
        equal = view.findViewById(R.id.equals_button);
        calculation = view.findViewById(R.id.result);

        equal.setOnClickListener(view1 -> {
            Integer alas, tinggi, hasil;

            alas = Integer.parseInt(base.getText().toString());
            tinggi = Integer.parseInt(height.getText().toString());

            hasil = (alas * tinggi) / 2;

            calculation.setText(hasil.toString());
        });

        return view;
    }
}