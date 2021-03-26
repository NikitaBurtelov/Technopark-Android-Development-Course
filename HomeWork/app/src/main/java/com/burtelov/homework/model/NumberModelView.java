package com.burtelov.homework.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.burtelov.homework.KeyTag;
import com.burtelov.homework.R;

class NumberModelView extends Fragment {
    public static String POSITION = KeyTag.POSITION.toString();
    private int position = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_large, container, false);

        Bundle bundle = getArguments();

        if (null != bundle) {
            position = bundle.getInt(POSITION) ;
        }
        if (null != savedInstanceState) {
            position = savedInstanceState.getInt(POSITION);
        }

        TextView textDetail = view.findViewById(R.id.textLarge);
        textDetail.setTextColor(NumberFactory.numberList.get(position).getColor());
        textDetail.setText(NumberFactory.numberList.get(position).getText());

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt(POSITION, position);
        super.onSaveInstanceState(bundle);
    }
}
