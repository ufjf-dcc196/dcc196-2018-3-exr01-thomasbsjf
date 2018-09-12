package com.example.ice.exercicioextratrab;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String PESSOA_NOME = "nome";
    public static final String ALUNO_MATRICULA = "siape";
    private static final int REQUEST_SIAPE = 1;
    private static final int REQUEST_MATRICULA = 1;
    private Button btnAluno, btnServidor, btnExterno;
    private TextView txtQtdAluno, txtQtdServidor, txtQtdExterno, txtMensagem;
    private EditText edt_nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMensagem = (TextView)findViewById(R.id.mensagem_txt);
        edt_nome = (EditText)findViewById(R.id.edt_nome);
        btnAluno = findViewById(R.id.btn_aluno);
        btnServidor = findViewById(R.id.btn_servidor);
        btnExterno = findViewById(R.id.btn_externo);
        txtQtdAluno = (TextView)findViewById(R.id.qtd_aluno_txt);
        txtQtdServidor = (TextView) findViewById(R.id.qtd_servidor_txt);
        txtQtdExterno = (TextView)findViewById(R.id.qtd_externo_txt);

        btnAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlunoActivity.class);
                intent.putExtra(PESSOA_NOME, edt_nome.getText().toString());
                startActivityForResult(intent, MainActivity.REQUEST_MATRICULA);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == MainActivity.REQUEST_SIAPE && resultCode == Activity.RESULT_OK && data != null) {
            Bundle bundleResultado = data.getExtras();
            String siape = bundleResultado.getString(MainActivity.ALUNO_MATRICULA);
            txtMensagem.setText("Olá professor de SIAPE: " + siape);
        }
    }
}
