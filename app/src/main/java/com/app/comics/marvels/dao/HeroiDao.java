package com.app.comics.marvels.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.app.comics.marvels.banco.Dao;
import com.app.comics.marvels.data.network.model.Heroi;

import java.util.ArrayList;
import java.util.List;


public class HeroiDao extends Dao {

    public static final String TABELA = "tb_herois";
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String IMAGEM = "imagem";
    //

    public HeroiDao(Context context) {
        super(context);
    }


    public List<Heroi> obterListaDeHerois() {
        List<Heroi> herois = new ArrayList<>();
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try {
            StringBuilder comando = new StringBuilder();
            comando.append(" select * from ")
                    .append(TABELA);


            cursor = db.rawQuery(comando.toString().toLowerCase(), null);
            //
            while (cursor.moveToNext()) {
                Heroi item;
                //
                String id = cursor.getString(cursor.getColumnIndex(ID));
                String nome = cursor.getString(cursor.getColumnIndex(NOME));
                String imagem = cursor.getString(cursor.getColumnIndex(IMAGEM));


                item = new Heroi(id, nome, imagem);
                herois.add(item);
            }

            cursor.close();

        } catch (Exception e) {
        }
        //
        fecharBanco();
        //
        return herois;
    }

    public void inserirHeroi(Heroi heroi) {
        abrirBanco();
        //
        ContentValues cv = new ContentValues();
        cv.put(ID, heroi.getId());
        cv.put(NOME, heroi.getNome());
        cv.put(IMAGEM, heroi.getImagem());
        //
        db.insert(TABELA, null, cv);
        //
        fecharBanco();

        Log.d("DAO", "heroi inserido: "+heroi.getNome());
    }

    public boolean verificaInclusaoDB(String idHeroi) {
        boolean incluso = false;
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try {
            //String comando = " select * from " + TABELA + " where idcontato = ? ";
            StringBuilder comando = new StringBuilder();
            comando
                    .append(" select * from ")
                    .append(TABELA)
                    .append(" where id = ")
                    .append("'"+idHeroi+"'");

            cursor = db.rawQuery(comando.toString().toLowerCase(), null);
            //
            if(cursor.moveToNext()){
                incluso = true;
            }


        } catch (Exception e) {
        }
        //
        fecharBanco();
        //
        return incluso;
    }

    public void apagarHeroi(String idHeroi) {
        abrirBanco();
        //
        String filtro = ID + " = ? ";
        final String[] argumentos = {String.valueOf(idHeroi)};

        db.delete(TABELA, filtro, argumentos);

        fecharBanco();
    }
}
