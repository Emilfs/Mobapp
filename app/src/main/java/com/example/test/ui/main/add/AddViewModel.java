package com.example.test.ui.main.add;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.test.data.income.Income;
import com.example.test.data.income.IncomeDao;

import java.util.Date;

public class AddViewModel extends ViewModel {

    private IncomeDao incomeDao;

    private MutableLiveData<String> amount = new MutableLiveData<>();

    private MutableLiveData<Boolean> isIncome = new MutableLiveData<>();

    public AddViewModel(IncomeDao incomeDao) {
        this.incomeDao = incomeDao;
    }

    public void onSubmitClick() {
        Income income = new Income();
        if (Boolean.TRUE.equals(isIncome.getValue())) {
            income.setAmount(Double.parseDouble(amount.getValue()));
        } else {
            income.setAmount(-Double.parseDouble(amount.getValue()));
        }
        income.setDate(new Date());

        incomeDao.insert(income);
    }

    public MutableLiveData<String> getAmount() {
        return amount;
    }

    public MutableLiveData<Boolean> getIsIncome() {
        return isIncome;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        private IncomeDao incomeDao;

        public Factory(IncomeDao incomeDao) {
            this.incomeDao = incomeDao;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new AddViewModel(incomeDao);
        }
    }
}