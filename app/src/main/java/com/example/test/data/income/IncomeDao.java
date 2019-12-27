package com.example.test.data.income;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface IncomeDao {

    @Query("SELECT * FROM income")
    List<Income> getAll();

    @Insert
    void insert(Income income);

    @Delete
    void delete(Income income);
}
