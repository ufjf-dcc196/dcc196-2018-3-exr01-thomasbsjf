package com.example.ice.exercicioextratrab;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ServidorActivity extends AppCompatActivity {

    public TextView txtServidorMensagem;
    public Button btnServidorConfirma;
    public EditText edtTextSiape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        txtServidorMensagem = (TextView)findViewById(R.id.txtAlunoMensagem);
        btnServidorConfirma = (Button)findViewById(R.id.btn_aluno_confirma);
        edtTextSiape = (EditText)findViewById(R.id.edt_siape);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String nome = extras.getString(MainActivity.PESSOA_NOME);
            txtServidorMensagem.setText("Olá "+nome+"!");
        }

        btnServidorConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultado = new Intent();
                resultado.putExtra(MainActivity.ALUNO_MATRICULA, edtTextSiape.getText().toString());
                setResult(Activity.RESULT_OK, resultado);

                finish();
            }
        });
    }

}
