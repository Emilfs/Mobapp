package com.example.test.data.income;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Income.class}, version = 1)
@TypeConverters(Converters.class)
public abstract class IncomeDb extends RoomDatabase {
    public abstract IncomeDao incomeDao();
}
