package com.example.test.ui.main.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import com.example.test.R;
import com.example.test.data.income.IncomeDb;
import com.example.test.databinding.FragmentAddBinding;

public class AddFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        IncomeDb db = Room.databaseBuilder(getActivity(), IncomeDb.class, "income")
                .allowMainThreadQueries()
                .build();

        AddViewModel.Factory factory = new AddViewModel.Factory(db.incomeDao());

        AddViewModel viewModel = ViewModelProviders.of(this, factory).get(AddViewModel.class);

        FragmentAddBinding binding = FragmentAddBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }
}