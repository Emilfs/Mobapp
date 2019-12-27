package com.example.test.data.income;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class IncomeDao_Impl implements IncomeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Income> __insertionAdapterOfIncome;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Income> __deletionAdapterOfIncome;

  public IncomeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIncome = new EntityInsertionAdapter<Income>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Income` (`id`,`date`,`amount`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Income value) {
        stmt.bindLong(1, value.getId());
        final Long _tmp;
        _tmp = __converters.dateToTimestamp(value.getDate());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, _tmp);
        }
        stmt.bindDouble(3, value.getAmount());
      }
    };
    this.__deletionAdapterOfIncome = new EntityDeletionOrUpdateAdapter<Income>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Income` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Income value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void insert(final Income income) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfIncome.insert(income);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Income income) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfIncome.handle(income);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Income> getAll() {
    final String _sql = "SELECT * FROM income";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final List<Income> _result = new ArrayList<Income>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Income _item;
        _item = new Income();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final Date _tmpDate;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDate);
        }
        _tmpDate = __converters.fromTimestamp(_tmp);
        _item.setDate(_tmpDate);
        final double _tmpAmount;
        _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
        _item.setAmount(_tmpAmount);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
