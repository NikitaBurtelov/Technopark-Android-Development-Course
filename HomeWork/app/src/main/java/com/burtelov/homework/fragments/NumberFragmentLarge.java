package com.burtelov.homework.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.burtelov.homework.KeyTag;
import com.burtelov.homework.R;
import com.burtelov.homework.model.NumberFactory;

public class NumberFragmentLarge extends Fragment {
    private final String COUNT = KeyTag.COUNT.toString();
    private int position = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_large, container, false);
        TextView textDetail = view.findViewById(R.id.text);

        Bundle bundle = getArguments();
        if (null != bundle) {
            position = bundle.getInt(COUNT);
        }
        if (null != savedInstanceState) {
            position = savedInstanceState.getInt(COUNT);
        }

        textDetail.setText(NumberFactory.numberList.get(position).getText());
        textDetail.setTextColor(NumberFactory.numberList.get(position).getColor());

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt(COUNT, position);
        super.onSaveInstanceState(bundle);
    }
}
