package br.com.koitim.gastos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.koitim.gastos.model.Categoria;
import br.com.koitim.gastos.model.Credor;
import br.com.koitim.gastos.model.Fonte;

/**
 * Created by koitim on 21/12/16.
 */

public class CredorDAO extends GenericDAO<Credor> {

  public CredorDAO(Context context) {
    super(context);
  }

  @Override
  public List<Credor> findAll() {
    Credor credor;
    List<Credor> credorList = new ArrayList();
    String sql = "SELECT * FROM " + Credor.TABELA + " ORDER BY " + Credor.NOME;
    Cursor cursor = mDataBase.rawQuery(sql, null);
    while (cursor.moveToNext()) {
      credor = new Credor(
          cursor.getLong(cursor.getColumnIndex(Credor.ID)),
          cursor.getString(cursor.getColumnIndex(Credor.NOME))
      );
      credorList.add(credor);
    }
    cursor.close();
    return credorList;
  }

  @Override
  public Credor find(int id) {
    Credor credor;

    Cursor cursor = mDataBase.query(
        Credor.TABELA, null, Credor.ID+"=?1", new String[]{String.valueOf(id)}, null, null, null
    );
    if (cursor.getCount() != 1) {
      return null;
    }
    cursor.moveToFirst();
    credor = new Credor(
        cursor.getLong(cursor.getColumnIndex(Credor.ID)),
        cursor.getString(cursor.getColumnIndex(Credor.NOME))
    );
    return credor;
  }

  @Override
  public ContentValues getContentValues(Credor credor) {
    ContentValues contentValues = new ContentValues();

    contentValues.put(Credor.ID, credor.getId());
    contentValues.put(Credor.NOME, credor.getNome());

    return contentValues;
  }
}
