package com.burtelov.homework.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.burtelov.homework.MainNumberFragment;
import com.burtelov.homework.R;
import com.burtelov.homework.model.Number;
import com.burtelov.homework.model.NumberFactory;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List<Number> listNumber;
    private final MainNumberFragment factoryNumberLarge;

    public RecyclerViewAdapter(MainNumberFragment listener, List<Number> values) {
        factoryNumberLarge = listener;
        listNumber = values;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_number, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setTextColor(NumberFactory.numberList.get(position).getColor());
        holder.textView.setText(NumberFactory.numberList.get(position).getText());

        holder.view.setOnClickListener(v -> {
            if (null != factoryNumberLarge) {
                factoryNumberLarge.factoryNumberLarge(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listNumber.size();
    }
}
