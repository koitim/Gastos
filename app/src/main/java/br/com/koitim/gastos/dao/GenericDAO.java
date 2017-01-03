package br.com.koitim.gastos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.koitim.gastos.db.DataBaseHelper;
import br.com.koitim.gastos.model.IModel;

/**
 * Created by koitim on 21/12/16.
 */

public abstract class GenericDAO <T extends IModel> {

  protected SQLiteDatabase mDataBase;

  public GenericDAO(Context context) {
    DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
    mDataBase = dataBaseHelper.getWritableDatabase();
  }

  public void insert(T obj) {
    mDataBase.insert(obj.getTabela(), null, getContentValues(obj));
  }

  public void update(T obj){
    mDataBase.update(obj.getTabela(), getContentValues(obj), "id = ?",
        new String[]{obj.getId().toString()});
  }

  public void delete(T obj){
    mDataBase.delete(obj.getTabela(), "id = ?", new String[]{obj.getId().toString()});
  }

  public abstract List<T> findAll();

  public abstract T find (int id);

  public abstract ContentValues getContentValues(T obj);
}
