package com.kkjang.stockapp.Bottom.revenue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.kkjang.stockapp.R;

public class RevenueFragment extends Fragment {

    private RevenueViewModel revenueViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        revenueViewModel =
                new ViewModelProvider(this).get(RevenueViewModel.class);
        View root = inflater.inflate(R.layout.fragment_revenue, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        revenueViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}