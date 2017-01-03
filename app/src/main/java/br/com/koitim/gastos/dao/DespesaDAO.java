package br.com.koitim.gastos.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.koitim.gastos.model.Categoria;
import br.com.koitim.gastos.model.Credor;
import br.com.koitim.gastos.model.Despesa;
import br.com.koitim.gastos.model.Favorecido;
import br.com.koitim.gastos.model.Fonte;

/**
 * Created by koitim on 23/12/16.
 */

public class DespesaDAO extends GenericDAO<Despesa> {

  private Context context;

  public DespesaDAO(Context context) {
    super(context);
    this.context = context;
  }

  @Override
  public List<Despesa> findAll() {
    Despesa despesa;
    List<Despesa> despesaList = new ArrayList();
    String sql = "SELECT * FROM " + Despesa.TABELA + " ORDER BY " + Despesa.DATA;
    Cursor cursor = mDataBase.rawQuery(sql, null);
    while (cursor.moveToNext()) {
      despesa = getDespesa(cursor);
      despesaList.add(despesa);
    }
    cursor.close();
    return despesaList;
  }

  @Override
  public Despesa find(int id) {
    Despesa despesa;
    Cursor cursor = mDataBase.query(
        Despesa.TABELA, null, Despesa.ID+"=?1", new String[]{String.valueOf(id)}, null, null, null
    );
    if (cursor.getCount() != 1) {
      return null;
    }
    cursor.moveToFirst();
    despesa = getDespesa(cursor);
    return despesa;
  }

  @Override
  public ContentValues getContentValues(Despesa favorecido) {
    ContentValues contentValues = new ContentValues();

    contentValues.put(Despesa.ID, favorecido.getId());
    contentValues.put(Despesa.DATA, favorecido.getData().toString());
    contentValues.put(Despesa.VALOR, favorecido.getValor());
    contentValues.put(Despesa.FONTE, favorecido.getFonte().toString());
    contentValues.put(Despesa.CATEGORIA, favorecido.getCategoria().toString());
    contentValues.put(Despesa.CREDOR, favorecido.getCredor().toString());
    contentValues.put(Despesa.FAVORECIDO, favorecido.getFavorecido().toString());

    return contentValues;
  }

  private Despesa getDespesa(Cursor cursor) {
    Long id = cursor.getLong(cursor.getColumnIndex(Despesa.ID));

    Date data = new Date(cursor.getLong(cursor.getColumnIndex(Despesa.DATA)));

    Double valor = cursor.getDouble(cursor.getColumnIndex(Despesa.VALOR));

    Long idFonte = cursor.getLong(cursor.getColumnIndex(Despesa.FONTE));
    FonteDAO fonteDAO = new FonteDAO(context);
    Fonte fonte = fonteDAO.find(idFonte.intValue());

    Long idCategoria = cursor.getLong(cursor.getColumnIndex(Despesa.CATEGORIA));
    CategoriaDAO categoriaDAO = new CategoriaDAO(context);
    Categoria categoria = categoriaDAO.find(idCategoria.intValue());

    Long idCredor = cursor.getLong(cursor.getColumnIndex(Despesa.CREDOR));
    CredorDAO credorDAO = new CredorDAO(context);
    Credor credor = credorDAO.find(idCredor.intValue());

    Long idFavorecido = cursor.getLong(cursor.getColumnIndex(Despesa.FAVORECIDO));
    FavorecidoDAO favorecidoDAO = new FavorecidoDAO(context);
    Favorecido favorecido = favorecidoDAO.find(idFavorecido.intValue());

    return new Despesa(id, data, valor, fonte, categoria, credor, favorecido);
  }
}
