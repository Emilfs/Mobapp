package com.example.test.ui.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import com.example.test.R;
import com.example.test.data.income.Income;
import com.example.test.data.income.IncomeDb;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.homeText);
        homeViewModel.getText().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer resId) {
                textView.setText(getString(resId));
            }
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}