package br.com.koitim.gastos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.koitim.gastos.model.Categoria;
import br.com.koitim.gastos.model.Fonte;

/**
 * Created by koitim on 21/12/16.
 */

public class CategoriaDAO extends GenericDAO<Categoria> {

  public CategoriaDAO(Context context) {
    super(context);
  }

  @Override
  public List<Categoria> findAll() {
    Categoria categoria;
    List<Categoria> categoriaList = new ArrayList();
    String sql = "SELECT * FROM " + Categoria.TABELA + " ORDER BY " + Categoria.NOME;
    Cursor cursor = mDataBase.rawQuery(sql, null);
    while (cursor.moveToNext()) {
      categoria = new Categoria(
          cursor.getLong(cursor.getColumnIndex(Categoria.ID)),
          cursor.getString(cursor.getColumnIndex(Categoria.NOME))
      );
      categoriaList.add(categoria);
    }
    cursor.close();
    return categoriaList;
  }

  @Override
  public Categoria find(int id) {
    Categoria categoria;

    Cursor cursor = mDataBase.query(
        Categoria.TABELA, null, Categoria.ID+"=?1", new String[]{String.valueOf(id)}, null, null, null
    );
    if (cursor.getCount() != 1) {
      return null;
    }
    cursor.moveToFirst();
    categoria = new Categoria(
        cursor.getLong(cursor.getColumnIndex(Fonte.ID)),
        cursor.getString(cursor.getColumnIndex(Fonte.NOME))
    );
    return categoria;
  }

  @Override
  public ContentValues getContentValues(Categoria fonte) {
    ContentValues contentValues = new ContentValues();

    contentValues.put(Categoria.ID, fonte.getId());
    contentValues.put(Categoria.NOME, fonte.getNome());

    return contentValues;
  }
}
