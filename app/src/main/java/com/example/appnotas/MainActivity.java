package com.example.appnotas;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.appnotas.databinding.ActivityMainBinding;

import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EditText et_texto;
    private AnotacaoPreferencia preferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        et_texto = findViewById(R.id.et_anotacao);
        preferencia = new AnotacaoPreferencia(getApplicationContext());


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String anotacao = et_texto.getText().toString();
                if(!anotacao.isEmpty()){
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }else{
                    Snackbar.make(view, "Preencha a anotação!!", Snackbar.LENGTH_LONG).show();
                }

            }
        });
        String anotacao = preferencia.recuperarAnotacao();
        if(!anotacao.isEmpty()){
            et_texto.setText(anotacao);
        }
    }


}