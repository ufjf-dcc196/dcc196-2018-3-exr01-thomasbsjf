    package com.example.ice.exercicioextratrab;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

    public class AlunoActivity extends AppCompatActivity {

    public TextView txtAlunoMensagem;
    public Button btnAlunoConfirma;
    public EditText edtTextMatricula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        txtAlunoMensagem = (TextView)findViewById(R.id.txtAlunoMensagem);
        btnAlunoConfirma = (Button)findViewById(R.id.btn_aluno_confirma);
        edtTextMatricula = (EditText)findViewById(R.id.edt_matricula_aluno);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String nome = extras.getString(MainActivity.PESSOA_NOME);
            txtAlunoMensagem.setText("Olá "+nome+"!");
        }

        btnAlunoConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultado = new Intent();
                resultado.putExtra(MainActivity.ALUNO_MATRICULA, edtTextMatricula.getText().toString());
                setResult(Activity.RESULT_OK, resultado);

                finish();
            }
        });
    }


}
