package com.example.test.ui.main.history;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.test.data.income.Income;
import com.example.test.data.income.IncomeDao;
import com.example.test.ui.main.add.AddViewModel;

import java.text.SimpleDateFormat;
import java.util.List;

public class HistoryViewModel extends ViewModel {

    private MutableLiveData<String> history = new MutableLiveData<>();

    public HistoryViewModel(IncomeDao incomeDao) {
        List<Income> incomes = incomeDao.getAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String s = "";
        for (Income income : incomes) {
            s += (sdf.format(income.getDate()) + " || " + income.getAmount() + "\n");
        }
        history.setValue(s);
    }

    public LiveData<String> getHistory() {
        return history;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        private IncomeDao incomeDao;

        public Factory(IncomeDao incomeDao) {
            this.incomeDao = incomeDao;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new HistoryViewModel(incomeDao);
        }
    }
}