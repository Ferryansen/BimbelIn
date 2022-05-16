package com.musang.bimbelin;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicReference;


public class CounterFragment extends Fragment {

    private TextView counter, reset;
    private ImageButton plus, minus;

    public CounterFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_counter, container, false);
        AtomicReference<Integer> count = new AtomicReference<>(0);

        counter = (TextView) view.findViewById(R.id.result_count);
        reset = (TextView) view.findViewById(R.id.reset_button);
        plus = (ImageButton) view.findViewById(R.id.plus_value);
        minus = (ImageButton) view.findViewById(R.id.minus_value);


        AtomicReference<SharedPreferences> totalCounter = new AtomicReference<>(this.getActivity().getSharedPreferences("SAVE_FILE", Context.MODE_PRIVATE));
        AtomicReference<SharedPreferences.Editor> spEditor = new AtomicReference<>(totalCounter.get().edit());

        AtomicReference<SharedPreferences> getTotalCounter = new AtomicReference<>(this.getActivity().getSharedPreferences("SAVE_FILE", Context.MODE_PRIVATE));
        count.set(getTotalCounter.get().getInt("TOTAL_SIMPENAN_COUNTER", 0));


        counter.setText(count.toString());


        plus.setOnClickListener(view1 -> {
            count.getAndSet(count.get() + 1);

            totalCounter.set(this.getActivity().getSharedPreferences("SAVE_FILE", Context.MODE_PRIVATE));
            spEditor.set(totalCounter.get().edit());
            spEditor.get().putInt("TOTAL_SIMPENAN_COUNTER", count.get());
            spEditor.get().apply();

            getTotalCounter.set(this.getActivity().getSharedPreferences("SAVE_FILE", Context.MODE_PRIVATE));
            count.set(getTotalCounter.get().getInt("TOTAL_SIMPENAN_COUNTER", 0));


            counter.setText(count.toString());
        });

        minus.setOnClickListener(view1 -> {
            if (count.get() != 0) {
                count.getAndSet(count.get() - 1);
            }

            totalCounter.set(this.getActivity().getSharedPreferences("SAVE_FILE", Context.MODE_PRIVATE));
            spEditor.set(totalCounter.get().edit());
            spEditor.get().putInt("TOTAL_SIMPENAN_COUNTER", count.get());
            spEditor.get().apply();

            getTotalCounter.set(this.getActivity().getSharedPreferences("SAVE_FILE", Context.MODE_PRIVATE));
            count.set(getTotalCounter.get().getInt("TOTAL_SIMPENAN_COUNTER", 0));


            counter.setText(count.toString());
        });

        reset.setOnClickListener(view1 -> {
            count.set(0);

            totalCounter.set(this.getActivity().getSharedPreferences("SAVE_FILE", Context.MODE_PRIVATE));
            spEditor.set(totalCounter.get().edit());
            spEditor.get().putInt("TOTAL_SIMPENAN_COUNTER", count.get());
            spEditor.get().apply();

            getTotalCounter.set(this.getActivity().getSharedPreferences("SAVE_FILE", Context.MODE_PRIVATE));
            count.set(getTotalCounter.get().getInt("TOTAL_SIMPENAN_COUNTER", 0));


            counter.setText(count.toString());

            Toast.makeText(view.getContext(), "Value has been reset", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}