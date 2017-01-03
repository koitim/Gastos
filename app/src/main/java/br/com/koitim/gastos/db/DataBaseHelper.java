package br.com.koitim.gastos.db;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by koitim on 21/12/16.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

  private static final String DATABASE_NAME = "gastos.db";
  private static final int DATABASE_VERSION = 5;

  private Context context;

  public DataBaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
    this.context = context;
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    readWriteSQL(db, "db/create.sql");
    readWriteSQL(db, "db/insert.sql");
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int versaoNova) {
    readWriteSQL(db, "db/update.sql");
    onCreate(db);
  }

  private void readWriteSQL(SQLiteDatabase db, String arquivoSQL) {
    try {
      String sql = null;

      AssetManager assetManager = context.getAssets();
      InputStream inputStream = assetManager.open(arquivoSQL);
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
      BufferedReader reader = new BufferedReader(inputStreamReader);

      while((sql = reader.readLine()) != null){
        db.execSQL(sql);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
