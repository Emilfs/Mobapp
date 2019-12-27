package com.example.test.ui.main.history;

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
import com.example.test.data.income.IncomeDb;
import com.example.test.databinding.FragmentAddBinding;
import com.example.test.databinding.FragmentHistoryBinding;
import com.example.test.ui.main.add.AddViewModel;

public class HistoryFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        IncomeDb db = Room.databaseBuilder(getActivity(), IncomeDb.class, "income")
                .allowMainThreadQueries()
                .build();

        HistoryViewModel.Factory factory = new HistoryViewModel.Factory(db.incomeDao());

        HistoryViewModel viewModel = ViewModelProviders.of(this, factory).get(HistoryViewModel.class);

        FragmentHistoryBinding binding = FragmentHistoryBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }
}