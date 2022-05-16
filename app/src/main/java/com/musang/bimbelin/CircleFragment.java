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


public class CircleFragment extends Fragment {

    private EditText radius;
    private Button equal;
    private TextView calculation;

    public CircleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circle, container, false);

        radius = view.findViewById(R.id.circle_radius);
        equal = view.findViewById(R.id.equals_button);
        calculation = view.findViewById(R.id.result);

        equal.setOnClickListener(view1 -> {
            Integer radiuss;
            double hasil;

            radiuss = Integer.parseInt(radius.getText().toString());

            hasil = 3.14 * radiuss * radiuss;

            calculation.setText(new DecimalFormat("##.##").format(hasil).toString());
        });


        return view;
    }
}