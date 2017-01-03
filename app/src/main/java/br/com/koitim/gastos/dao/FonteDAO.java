package br.com.koitim.gastos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.koitim.gastos.model.Fonte;

/**
 * Created by koitim on 21/12/16.
 */

public class FonteDAO extends GenericDAO<Fonte> {

  public FonteDAO(Context context) {
    super(context);
  }

  @Override
  public List<Fonte> findAll() {
    Fonte fonte;
    List<Fonte> fonteList = new ArrayList();
    String sql = "SELECT * FROM " + Fonte.TABELA + " ORDER BY " + Fonte.NOME;
    //Cursor cursor = mDataBase.rawQuery(sql, null);
    Cursor cursor = mDataBase.query(Fonte.TABELA, null, null, null, null, null, Fonte.NOME);
    while (cursor.moveToNext()) {
      fonte = new Fonte(
          cursor.getLong(cursor.getColumnIndex(Fonte.ID)),
          cursor.getString(cursor.getColumnIndex(Fonte.NOME))
      );
      fonteList.add(fonte);
    }
    cursor.close();
    return fonteList;
  }

  @Override
  public Fonte find(int id) {
    Fonte fonte;

    Cursor cursor = mDataBase.query(
        Fonte.TABELA, null, Fonte.ID+"=?1", new String[]{String.valueOf(id)}, null, null, null
    );
    if (cursor.getCount() != 1) {
      return null;
    }
    cursor.moveToFirst();
    fonte = new Fonte(
        cursor.getLong(cursor.getColumnIndex(Fonte.ID)),
        cursor.getString(cursor.getColumnIndex(Fonte.NOME))
    );
    return fonte;
  }

  @Override
  public ContentValues getContentValues(Fonte fonte) {
    ContentValues contentValues = new ContentValues();

    contentValues.put(Fonte.ID, fonte.getId());
    contentValues.put(Fonte.NOME, fonte.getNome());

    return contentValues;
  }
}
