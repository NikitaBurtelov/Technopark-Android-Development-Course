package com.burtelov.homework;

import android.os.Bundle;

import com.burtelov.homework.fragments.NumberFragment;
import com.burtelov.homework.fragments.NumberFragmentLarge;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MainNumberFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_fragment, new NumberFragment())
                    .commit();
        }
    }

    @Override
    public void factoryNumberLarge(int count) {
        Bundle bundle = new Bundle();
        bundle.putInt(KeyTag.COUNT.toString(), count);
        NumberFragmentLarge fragment = new NumberFragmentLarge();
        fragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}