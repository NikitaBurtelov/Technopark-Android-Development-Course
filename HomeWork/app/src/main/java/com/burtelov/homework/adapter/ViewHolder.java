package com.burtelov.homework.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.burtelov.homework.R;

class ViewHolder extends RecyclerView.ViewHolder {
    final View view;
    final TextView textView;

    ViewHolder(View view) {
        super(view);
        this.view = view;
        this.textView = view.findViewById(R.id.text_view_number);
    }
}
