package com.musang.bimbelin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SquareFragment extends Fragment {

    private EditText sides;
    private Button equal;
    private TextView calculation;

    public SquareFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_square, container, false);

        sides = view.findViewById(R.id.square_side);
        equal = view.findViewById(R.id.equals_button);
        calculation = view.findViewById(R.id.result);

        equal.setOnClickListener(view1 -> {
            Integer sisi, hasil;
            sisi = Integer.parseInt(sides.getText().toString());

            hasil = sisi * sisi;

            calculation.setText(hasil.toString());
        });

        return view;
    }
}