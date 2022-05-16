package com.musang.bimbelin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PyramidFragment extends Fragment {

    private EditText baseWidth, baseLength, height;
    private Button equal;
    private TextView calculation;

    public PyramidFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pyramid, container, false);

        baseWidth = view.findViewById(R.id.pyramid_base_width);
        baseLength = view.findViewById(R.id.pyramid_base_length);
        height = view.findViewById(R.id.pyramid_height);
        equal = view.findViewById(R.id.equals_button_volume);
        calculation = view.findViewById(R.id.result_volume);

        equal.setOnClickListener(view1 -> {
            Integer alasPanjang, alasLebar, tinggi, hasil;

            alasPanjang = Integer.parseInt(baseWidth.getText().toString());
            alasLebar = Integer.parseInt(baseLength.getText().toString());
            tinggi = Integer.parseInt(height.getText().toString());

            hasil = (alasPanjang * alasLebar * tinggi) / 3;

            calculation.setText(hasil.toString());
        });

        return view;
    }
}