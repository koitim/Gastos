package br.com.koitim.gastos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.koitim.gastos.model.Favorecido;

/**
 * Created by koitim on 23/12/16.
 */

public class FavorecidoDAO extends GenericDAO<Favorecido> {

  public FavorecidoDAO(Context context) {
    super(context);
  }

  @Override
  public List<Favorecido> findAll() {
    Favorecido favorecido;
    List<Favorecido> favorecidoList = new ArrayList();
    String sql = "SELECT * FROM " + Favorecido.TABELA + " ORDER BY " + Favorecido.NOME;
    Cursor cursor = mDataBase.rawQuery(sql, null);
    while (cursor.moveToNext()) {
      favorecido = new Favorecido(
          cursor.getLong(cursor.getColumnIndex(Favorecido.ID)),
          cursor.getString(cursor.getColumnIndex(Favorecido.NOME))
      );
      favorecidoList.add(favorecido);
    }
    cursor.close();
    return favorecidoList;
  }

  @Override
  public Favorecido find(int id) {
    Favorecido favorecido;

    Cursor cursor = mDataBase.query(
        Favorecido.TABELA, null, Favorecido.ID+"=?1", new String[]{String.valueOf(id)}, null, null, null
    );
    if (cursor.getCount() != 1) {
      return null;
    }
    cursor.moveToFirst();
    favorecido = new Favorecido(
        cursor.getLong(cursor.getColumnIndex(Favorecido.ID)),
        cursor.getString(cursor.getColumnIndex(Favorecido.NOME))
    );
    return favorecido;
  }

  @Override
  public ContentValues getContentValues(Favorecido favorecido) {
    ContentValues contentValues = new ContentValues();

    contentValues.put(Favorecido.ID, favorecido.getId());
    contentValues.put(Favorecido.NOME, favorecido.getNome());

    return contentValues;
  }
}