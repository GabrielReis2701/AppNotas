package com.example.appnotas;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencia {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private final static String NOME_ARQUIVO = "anotacao";
    private final static String CHAVE = "nota";
    private Context context;


    public AnotacaoPreferencia(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE, anotacao);
        editor.commit();
    }

    public String recuperarAnotacao(){
        String anotacao = preferences.getString(CHAVE, "");
        return anotacao;
    }


}
