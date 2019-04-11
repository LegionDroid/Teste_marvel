package com.app.comics.marvels.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            StringBuilder sb = new StringBuilder();
            //
            // tabela 01
            sb.append("CREATE TABLE IF NOT EXISTS [tb_herois] (\n" +
                    "  [id] TEXT NOT NULL, \n" +
                    "  [nome] TEXT NOT NULL, \n" +
                    "  [imagem] TEXT NOT NULL)");

            // tabela 02
            sb.append(""); // script criacao tabelas ;

            String[] comandos = sb.toString().split(";");

            for (int i = 0; i < comandos.length; i++) {
                db.execSQL(comandos[i].toLowerCase());
            }
        } catch (Exception e){
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            StringBuilder sb = new StringBuilder();
            //
            // tabela 01
            sb.append("DROP TABLE IF EXISTS [tb_herois;"); // script criacao tabelas ;

            String[] comandos = sb.toString().split(";");

            for (int i = 0; i < comandos.length; i++) {
                db.execSQL(comandos[i].toLowerCase());
            }
        } catch (Exception e){
        }

        onCreate(db);
    }
}
