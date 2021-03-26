package com.burtelov.homework.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.burtelov.homework.KeyTag;
import com.burtelov.homework.MainNumberFragment;
import com.burtelov.homework.R;
import com.burtelov.homework.adapter.RecyclerViewAdapter;
import com.burtelov.homework.model.NumberFactory;

public class NumberFragment extends Fragment {
    private final String NUMBER = KeyTag.NUMBER.toString();
    private int countColumn;
    private MainNumberFragment factoryNumberLarge;
    private RecyclerViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orientation  = getResources().getConfiguration().orientation;
        countColumn = (orientation == Configuration.ORIENTATION_PORTRAIT) ? 3 : 4;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_list, container, false);

        view.findViewById(R.id.floatingActionButton).setOnClickListener((View itemView) -> {
            int position = NumberFactory.createNumber();
            adapter.notifyItemInserted(position);
        });

        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(context, countColumn));

        if (savedInstanceState != null) {
            int count = savedInstanceState.getInt(NUMBER) - NumberFactory.numberList.size();

            for (int i = 0; i < count; ++i) {
                NumberFactory.createNumber();
            }
        }

        adapter = new RecyclerViewAdapter(factoryNumberLarge, NumberFactory.numberList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        factoryNumberLarge = (MainNumberFragment) context;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(NUMBER, NumberFactory.numberList.size());
        super.onSaveInstanceState(outState);
    }
}
