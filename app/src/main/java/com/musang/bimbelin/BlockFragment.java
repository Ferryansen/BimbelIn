package com.musang.bimbelin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class BlockFragment extends Fragment {

    private EditText width, length, height;
    private Button equal;
    private TextView calculation;

    public BlockFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_block, container, false);

        width = view.findViewById(R.id.block_width);
        length = view.findViewById(R.id.block_length);
        height = view.findViewById(R.id.block_height);
        equal = view.findViewById(R.id.equals_button_volume);
        calculation = view.findViewById(R.id.result_volume);

        equal.setOnClickListener(view1 -> {
            Integer panjang, lebar, tinggi, hasil;

            panjang = Integer.parseInt(width.getText().toString());
            lebar = Integer.parseInt(length.getText().toString());
            tinggi = Integer.parseInt(height.getText().toString());

            hasil = panjang * lebar * tinggi;

            calculation.setText(hasil.toString());
        });

        return view;
    }
}