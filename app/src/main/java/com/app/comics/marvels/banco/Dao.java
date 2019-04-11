package com.app.comics.marvels.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Dao {

    private Context context;
    protected SQLiteDatabase db;

    public Dao(Context context) {
        this.context = context;
    }

    public void abrirBanco(){
        SQLiteHelper var = new SQLiteHelper(
                context,
                Constantes.BANCO,
                null,
                Constantes.VERSAO
        );

        this.db = var.getWritableDatabase(); // cria o banco de dados
    }

    public void fecharBanco(){
        if (db != null && db.isOpen()){
            db.close();
        }
    }
}
