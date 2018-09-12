package com.example.ice.exercicioextratrab;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExternoActivity extends AppCompatActivity {

    public TextView txtExternoMensagem;
    public Button btnExternoConfirma;
    public EditText edtTextEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        txtExternoMensagem = (TextView)findViewById(R.id.txtExternoMensagem);
        btnExternoConfirma = (Button)findViewById(R.id.btn_confirma_externo);
        edtTextEmail = (EditText)findViewById(R.id.edt_email);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String nome = extras.getString(MainActivity.PESSOA_NOME);
            txtExternoMensagem.setText("Olá "+nome+"!");
        }

        btnExternoConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultado = new Intent();
                resultado.putExtra(MainActivity.EXTERNO_EMAIL, edtTextEmail.getText().toString());
                setResult(Activity.RESULT_OK, resultado);

                finish();
            }
        });
    }
}
