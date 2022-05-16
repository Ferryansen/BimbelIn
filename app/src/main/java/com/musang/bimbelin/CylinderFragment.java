package com.musang.bimbelin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class CylinderFragment extends Fragment {

    private EditText radius, height;
    private Button equal;
    private TextView calculation;

    public CylinderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cylinder, container, false);

        radius = view.findViewById(R.id.cylinder_radius);
        height = view.findViewById(R.id.cylinder_height);
        equal = view.findViewById(R.id.equals_button_volume);
        calculation = view.findViewById(R.id.result_volume);

        equal.setOnClickListener(view1 -> {
            Integer radiuss, tinggi;
            double hasil;

            radiuss = Integer.parseInt(radius.getText().toString());
            tinggi = Integer.parseInt(height.getText().toString());

            hasil = 3.14 * Math.pow(radiuss, 2) * tinggi;

            calculation.setText(new DecimalFormat("##.##").format(hasil).toString());
        });

        return view;
    }
}